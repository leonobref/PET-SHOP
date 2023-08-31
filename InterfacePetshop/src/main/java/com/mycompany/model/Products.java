package com.mycompany.model;

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
    private File file = new File("DadosPetShop.xls");

    public Products(){}

    public Products(String name, String category, String costprice, String saleprice, String insertiondate) {
        this.name = name;
        this.category = category;
        this.sales = "0";
        this.quantity = "0";
        this.costprice = costprice;
        this.saleprice = saleprice;
        this.active = "1";
        this.insertiondate = insertiondate;
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

        Cell c = products.getCell(9,0);
        String quant = c.getContents();
        int quantidade = Integer.parseInt(quant);

        WritableWorkbook copy = Workbook.createWorkbook(file, workbook);
        WritableSheet productscopy = copy.getSheet(2);

        Label label = new Label(0, quantidade, this.name);
        productscopy.addCell(label);

        Number number = new Number(1, quantidade, quantidade);
        productscopy.addCell(number);
        this.code = String.valueOf(quantidade + 1);

        label = new Label(2, quantidade, this.category);
        productscopy.addCell(label);

        number = new Number(3, quantidade, 0);
        productscopy.addCell(number);

        number = new Number(4, quantidade, 0);
        productscopy.addCell(number);

        number = new Number(5,quantidade, Double.parseDouble(this.costprice));
        productscopy.addCell(number);

        number = new Number(6,quantidade, Double.parseDouble(this.saleprice));

        productscopy.addCell(number);

        number = new Number(7,quantidade, 1);
        productscopy.addCell(number);

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
        if (cell.getType() == CellType.LABEL) {
            Label l = (Label) cell;
            l.setString(novastring);
        } else if (cell.getType() == CellType.NUMBER) {
            double numero = Double.parseDouble(novastring);
            Number n = (Number) cell;
            n.setValue(numero);
        } else {
            System.out.println("Other data... ");
        }
    }
    
     public void excluirUsuario() {
        try {
            
    		if (!file.exists()) {
                System.out.println("O arquivo  não existe.");
                return; // Aqui você pode decidir o que fazer em caso de arquivo já existente.
            }
            Workbook workbook = Workbook.getWorkbook(file);
            WritableWorkbook copy = Workbook.createWorkbook(file, workbook);
            WritableSheet usuarioSheet = copy.getSheet(2); // Assumindo que a planilha que queremos usar é a primeira (índice 0)

            int totalLinhas = usuarioSheet.getRows();
            int linhaExclusao = -1;

            String codProd = getCode(); // Usando o getter para obter o email do próprio objeto Users

            // Procurar o usuário na planilha pelo email
            for (int i = 1; i < totalLinhas; i++) {
                Cell cell = usuarioSheet.getCell(1, i); // Coluna 2 contém os emails
                String email = cell.getContents();
                if (email.equals(codProd)) {
                    linhaExclusao = i;
                    break;
                }
            }

            if (linhaExclusao != -1) {
                // Encontrou o usuário pelo email e agora vamos remover a linha
                usuarioSheet.removeRow(linhaExclusao);
                copy.write();
                copy.close();
                System.out.println("Usuário excluído com sucesso!");
            } else {
                System.out.println("Usuário não encontrado na planilha.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }
    }
}
