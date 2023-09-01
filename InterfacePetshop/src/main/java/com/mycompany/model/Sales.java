package com.mycompany.model;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Sales
{
    private String product;
    private String product_code;
    private String value;
    private String quantity;
    private String date;
    private String sale;
    private String customer_name;
    private String customer_last_name;
    private String customer_code;
    private String lucro;

    // Construtores
    public Sales() {}

    public Sales(String product, String product_code, String value, String quantity, String date, String sale, String customer_name,
                 String customer_last_name, String customer_code)
    {
        this.product = product;
        this.product_code = String.valueOf(product_code);
        this.value = value;
        this.quantity = quantity;
        this.date = date;
        this.sale = sale;
        this.customer_name = customer_name;
        this.customer_last_name = customer_last_name;
        this.customer_code = customer_code;
    }

    // Getters e Setters

    public String getSale() { return sale; }
    public String getValue() { return value; }
    public String getCustomer_code() { return customer_code; }
    public String getProduct_code() { return product_code; }
    public String getQuantity() { return quantity; }
    public String getCustomer_last_name() { return customer_last_name; }
    public String getCustomer_name() { return customer_name; }
    public String getDate()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String saleDate = dateFormat.format(new Date());

        return saleDate;
    }
    public String getProduct() { return product; }
    public String getLucro(){return lucro;}

    public void setCustomer_code(String customer_code) { this.customer_code = customer_code; }
    public void setCustomer_last_name(String customer_last_name) { this.customer_last_name = customer_last_name; }
    public void setCustomer_name(String customer_name) { this.customer_name = customer_name; }
    public void setDate(String date) { this.date = date; }
    public void setProduct(String product) { this.product = product; }
    public void setProduct_code(String product_code) { this.product_code = product_code; }
    public void setSale(String sale) { this.sale = sale; }
    public void setQuantity(String quantity) { this.quantity = quantity; }
    public void setValue(String value) { this.value = value; }
     public void setLucro(String value) { this.lucro = value; }

    public static void createNewFile()
    {
       try {
    		// Manter Um nome pAdrão
    	File file = new File("Pet Shop Vendas.xls");
    		if (file.exists()) {
                System.out.println("O arquivo " + file + " já existe.");
                return ; 
                // Aqui você pode decidir o que fazer em caso de arquivo já existente.
            }
            // Criar um arquivo Excel e uma planilha
            WritableWorkbook workbook = Workbook.createWorkbook(file);
            WritableSheet sheet = workbook.createSheet("Sales", 0);
            
            // Escrever dados na planilha
            Label label = new Label(0, 0, "PRODUCT");
            sheet.addCell(label);

            label = new Label(1, 0, "PRODUCT CODE");
            sheet.addCell(label);
            
            label = new Label(2, 0, "VALUE");
            sheet.addCell(label);
            
            label = new Label(3, 0, "QUANTITY");
            sheet.addCell(label);

            label = new Label(4, 0, "DATE");
            sheet.addCell(label);

            label = new Label(5, 0, "SALE");
            sheet.addCell(label);

            label = new Label(6, 0, "CUSTOMER NAME");
            sheet.addCell(label);

            label = new Label(7, 0, "CUSTOMER LAST NAME");
            sheet.addCell(label);

            label = new Label(8, 0, "CUSTOMER CODE");
            sheet.addCell(label);

          
            

            // Salvar o arquivo Excel
            workbook.write();
            workbook.close();

            System.out.println("Dados escritos no arquivo Excel com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ;
    }

    public  void CadastrarVenda(){
         try {
            File file = new File("DadosPetShop.xls");
            Workbook workbook = Workbook.getWorkbook(file);
            WritableWorkbook copy = Workbook.createWorkbook(file, workbook);
            WritableSheet VendaSheet = copy.getSheet(4); 
            WritableSheet ProdSheet = copy.getSheet(2); // Assumindo que a planilha que queremos usar é a primeira (índice 0)

            int quantidadeVendas = VendaSheet.getRows(); // Obter o número de linhas (usuários) já cadastrados

            Label nomeLabel = new Label(0, quantidadeVendas, getProduct());
            VendaSheet.addCell(nomeLabel);

            Label complementoLabel = new Label(1, quantidadeVendas, getProduct_code());
            VendaSheet.addCell(complementoLabel);
            
            Label EmploymentLabel = new Label(2, quantidadeVendas, getValue());
            VendaSheet.addCell(EmploymentLabel);

            Label emailLabel = new Label(3, quantidadeVendas, getQuantity());
            VendaSheet.addCell(emailLabel);

            Label dataLabel = new Label(4, quantidadeVendas, getDate());
            VendaSheet.addCell(dataLabel);

            Label senhaLabel = new Label(5, quantidadeVendas, getSale());
            VendaSheet.addCell(senhaLabel);

            Label numeroLabel = new Label(6, quantidadeVendas, getCustomer_name());
            VendaSheet.addCell(numeroLabel);

            Label adminLabel = new Label(7, quantidadeVendas, getCustomer_last_name());
            VendaSheet.addCell(adminLabel);

            Label ativoLabel = new Label(8, quantidadeVendas, getCustomer_code());
            VendaSheet.addCell(ativoLabel);

            Label cargoLabel = new Label(9, quantidadeVendas,"0");
            VendaSheet.addCell(cargoLabel);
            
            Label LucroLabel = new Label(10, quantidadeVendas,getLucro());
            VendaSheet.addCell(LucroLabel);
            
           
            
            
            
            

            copy.write();
            copy.close();

            System.out.println("Venda cadastrada com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    public static void modifyData(WritableCell cell, String novastring) throws Exception
    {
            Label n = (Label) cell;
            n.setString(novastring);
       
            System.out.println(" Usuario Alterado ");
    }

    public void excluirProduto(String nomeDoArquivo) throws IOException, BiffException, WriteException{
        File file = new File("DadosPetShop.xls");
            
            //Criar uma Planilha editável
            Workbook file1 = Workbook.getWorkbook(file);
            WritableWorkbook writeBook =Workbook.createWorkbook(file,file1);
            WritableSheet usersheet = writeBook.getSheet(4);
            
            int linhaExclusao = -1;
            
            //Procurar Por nome e Saber a Linha
            String productCode = getProduct_code();
            for(int i = 0;i < usersheet.getRows();i++){
                if(productCode.equals(usersheet.getCell(0,i).getContents())){
                    linhaExclusao = i;
                }
            }
            
            //Excluindo
            if(linhaExclusao != -1){
               usersheet.removeRow(linhaExclusao);
            }
            
            //Escrevendo e fechando//
            writeBook.write();
            writeBook.close();
            
    }
}
