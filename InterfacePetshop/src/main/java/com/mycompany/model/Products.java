package com.mycompany.model;

import static com.mycompany.components.FrameDadosProduto.prod;
import java.io.File;
import java.io.IOException;

import jxl.CellType;
import jxl.write.*;
import jxl.Cell;
import jxl.Workbook;
import jxl.Sheet;
import jxl.read.biff.BiffException;
import jxl.write.Number;

public class Products {
    private String name;
    private String code;
    private String category;
    private String sales;
    private String quantity;
    private String costprice;
    private String saleprice;
    private String active;
    private String insertiondate;
    File file = new File("DadosPetShop.xls");
    public Products(){}

    public Products(String name, String category, String costprice, String saleprice, String quantity) {
        this.name = name;
        this.category = category;
        this.costprice = costprice;
        this.saleprice = saleprice;
        this.quantity = quantity;
        
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

    public String getCostprice() {
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

    public String getInsertiondate() {
        return insertiondate;
    }

    public void setInsertiondate(String insertiondate) {
        this.insertiondate = insertiondate;
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

    public void escrever_produtos() throws Exception {
        
        Workbook workbook = Workbook.getWorkbook(file);
        Sheet products = workbook.getSheet(2);

        
        int quantidade = products.getRows();

        WritableWorkbook copy = Workbook.createWorkbook(file, workbook);
        WritableSheet productscopy = copy.getSheet(2);

        Label label = new Label(0, quantidade, this.name);
        productscopy.addCell(label);
        
        setCode(String.valueOf(productscopy.getRows() -1));
        label = new Label(1, quantidade, this.code);
        productscopy.addCell(label);
        

        label = new Label(2, quantidade, this.category);
        productscopy.addCell(label);

        label = new Label(3, quantidade,"0" );
        productscopy.addCell(label);

        label = new Label(4, quantidade, this.quantity );
        productscopy.addCell(label);

        label = new Label(5,quantidade, this.costprice);
        productscopy.addCell(label);

        label = new Label(6,quantidade, this.saleprice);
        productscopy.addCell(label);

        label= new Label(7,quantidade, "1");
        productscopy.addCell(label);

        label = new Label(8, quantidade, this.insertiondate);
        productscopy.addCell(label);

        WritableCell c1 = productscopy.getWritableCell(9, 0);
        quantidade++;
        String novodisponivel = Integer.toString(quantidade);
        modifyData(c1, novodisponivel);

        copy.write();
        copy.close();
    }
    public void modifyData(WritableCell cell, String novastring) throws Exception {
        
            Label l = (Label) cell;
            l.setString(novastring);
       
        
    }
    
    public void excluirUsuario(int linha) {
        try {
          
    		if (!file.exists()) {
                System.out.println("O arquivo   não existe.");
                return; // Aqui você pode decidir o que fazer em caso de arquivo já existente.
            }
            Workbook workbook = Workbook.getWorkbook(file);
            WritableWorkbook copy = Workbook.createWorkbook(file, workbook);
            WritableSheet usuarioSheet = copy.getSheet(2); // Assumindo que a planilha que queremos usar é a primeira (índice 0)

            
            

            
                // Encontrou o usuário pelo email e agora vamos remover a linha
                usuarioSheet.removeRow(linha);
                copy.write();
                copy.close();
                System.out.println("Usuário excluído com sucesso!");
            
                System.out.println("Usuário não encontrado na planilha.");
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }
    }
}
