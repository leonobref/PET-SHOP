package com.mycompany.model;

import java.io.File;
import java.io.IOException;

import jxl.CellType;
import jxl.write.*;
import jxl.Cell;
import jxl.Workbook;
import jxl.Sheet;
import jxl.write.Number;

public class Products {
    private String name;
    private int code;
    private String category;
    private int sales;
    private int quantity;
    private double costprice;
    private double saleprice;
    private int active;
    private String insertiondate;

    public Products(){}

    public Products(String name, String category, double costprice, int saleprice,String quantity) {
        this.name = name;
        this.category = category;
        
        this.costprice = costprice;
        this.saleprice = saleprice;
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCostprice() {
        return costprice;
    }

    public void setCostprice(double costprice) {
        this.costprice = costprice;
    }

    public double getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(double saleprice) {
        this.saleprice = saleprice;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
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

    public void escrever_produtos(String filename) throws Exception {
        File file = new File(filename);
        Workbook workbook = Workbook.getWorkbook(file);
        Sheet products = workbook.getSheet(2);

        Cell c = products.getCell(9,0);
        String quant = c.getContents();
        int quantidade = Integer.parseInt(quant);

        WritableWorkbook copy = Workbook.createWorkbook(new File(filename), workbook);
        WritableSheet productscopy = copy.getSheet(2);

        Label label = new Label(0, quantidade, this.name);
        productscopy.addCell(label);

        Number number = new Number(1, quantidade, quantidade);
        productscopy.addCell(number);
        this.code = quantidade + 1;

        label = new Label(2, quantidade, this.category);
        productscopy.addCell(label);

        number = new Number(3, quantidade, 0);
        productscopy.addCell(number);

        number = new Number(4, quantidade, 0);
        productscopy.addCell(number);

        number = new Number(5,quantidade, this.costprice);
        productscopy.addCell(number);

        number = new Number(6,quantidade, this.saleprice);
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
}
