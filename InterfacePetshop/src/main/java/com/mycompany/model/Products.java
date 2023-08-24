package com.mycompany.model;

import java.io.File;
import java.io.IOException;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class Products {
    private String name;
    private String code;
    private String category;
    private String sales;
    private String quantity;
    private String costprice;
    private String saleprice;
    private String active;

    public Products(){}

    public Products(String name, String code, String category, String sales, String quantity, String costprice, String saleprice, String active) {
        this.name = name;
        this.code = code;
        this.category = category;
        this.sales = sales;
        this.quantity = quantity;
        this.costprice = costprice;
        this.saleprice = saleprice;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String  getCostprice() {
        return costprice;
    }

    public void setCostprice(String costprice) {
        this.costprice = costprice;
        
    }

    public String getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(String saleprice) {
        this.saleprice = saleprice;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Products{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", category='" + category + '\'' +
                ", sales=" + sales +
                ", quantity=" + quantity +
                ", costprice=" + costprice +
                ", saleprice=" + saleprice +
                ", active=" + active +
                '}';
    
        
    }
    public void  escreverDadosEmExcel() {
    	try {
    		// Manter Um nome pAdrão
    	File file = new File("Pet Shop Produtos.xls");
    		if (file.exists()) {
                System.out.println("O arquivo " + file + " já existe.");
                return ; // Aqui você pode decidir o que fazer em caso de arquivo já existente.
            }
            // Criar um arquivo Excel e uma planilha
            WritableWorkbook workbook = Workbook.createWorkbook(file);
            WritableSheet sheet = workbook.createSheet("Produtos", 0);
            
            // Escrever dados na planilha
            Label label = new Label(0, 0, "NAME");
            sheet.addCell(label);

            label = new Label(1, 0, "CODE");
            sheet.addCell(label);
            
            label = new Label(2, 0, "CATEGORY");
            sheet.addCell(label);
            
            label = new Label(3, 0, "SALES");
            sheet.addCell(label);

            label = new Label(4, 0, "QUANTITY");
            sheet.addCell(label);

            label = new Label(5, 0, "COSTPRICE");
            sheet.addCell(label);

            label = new Label(6, 0, "COSTSALE");
            sheet.addCell(label);

            label = new Label(7, 0, "ACTIVE");
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
    
    public void cadastrarProduto() {
        try {
            File file = new File("Pet Shop Produtos.xls");
            Workbook workbook = Workbook.getWorkbook(file);
            WritableWorkbook copy = Workbook.createWorkbook(file, workbook);
            WritableSheet produtoSheet = copy.getSheet(0); // Assumindo que a planilha que queremos usar é a primeira (índice 0)

            int quantidadeDeProdutos = produtoSheet.getRows(); // Obter o número de linhas (usuários) já cadastrados

            Label nomeLabel = new Label(0, quantidadeDeProdutos, getName());
            produtoSheet.addCell(nomeLabel);

            Label complementoLabel = new Label(1, quantidadeDeProdutos, getCode());
            produtoSheet.addCell(complementoLabel);
            
            Label EmploymentLabel = new Label(2, quantidadeDeProdutos, getCategory());
            produtoSheet.addCell(EmploymentLabel);

            Label emailLabel = new Label(3, quantidadeDeProdutos, "0");
            produtoSheet.addCell(emailLabel);

            Label dataLabel = new Label(4, quantidadeDeProdutos, getQuantity());
            produtoSheet.addCell(dataLabel);

            Label senhaLabel = new Label(5, quantidadeDeProdutos, getCostprice());
            produtoSheet.addCell(senhaLabel);

            Label numeroLabel = new Label(6, quantidadeDeProdutos, getSaleprice());
            produtoSheet.addCell(numeroLabel);

            Label adminLabel = new Label(7, quantidadeDeProdutos, getActive());
            produtoSheet.addCell(adminLabel);

            Label ativoLabel = new Label(8, quantidadeDeProdutos,"0" );
            produtoSheet.addCell(ativoLabel);

            

            

            copy.write();
            copy.close();

            System.out.println("Produto cadastrado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void modifyData(WritableCell cell, String novastring) throws Exception {
         
       
            Label n = (Label) cell;
            n.setString(novastring);
       
            System.out.println(" Usuario Alterado ");
        }
    
        
        
    
    public void excluirUsuario() throws IOException, BiffException, WriteException {
        
            File file = new File("Pet Shop Produtos.xls");
            
            //Criar uma Planilha editável
            Workbook file1 = Workbook.getWorkbook(file);
            WritableWorkbook writeBook =Workbook.createWorkbook(file,file1);
            WritableSheet usersheet = writeBook.getSheet(0);
            
            int linhaExclusao = -1;
            
            //Procurar Por nome e Saber a Linha
            String nome = getName();
            for(int i = 0;i < usersheet.getRows();i++){
                if(nome.equals(usersheet.getCell(0,i).getContents())){
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
