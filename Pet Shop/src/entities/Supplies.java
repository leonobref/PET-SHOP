package entities;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.Number;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Supplies
{
    private String product;
    private int product_code;
    private int supply;
    private String provider;
    private String date;
    private double cost;

    // Construtores
    public Supplies() {}

    public Supplies(String product, int supply, String provider, String date, double cost)
    {
        this.product = product;
        this.product_code = -1;
        this.supply = supply;
        this.provider = provider;
        this.date = date;
        this.cost = cost;
    }

    public Supplies(int product_code, int supply, String provider, String date, double cost)
    {
        this.product = "";
        this.product_code = product_code;
        this.supply = supply;
        this.provider = provider;
        this.date = date;
        this.cost = cost;
    }

    // Getters e Setters
    public String getProduct() { return product; }
    public int getProduct_code() { return product_code; }
    public int getSupply() { return supply; }
    public String getProvider() {return provider;}
    public String getDate() { return date; }
    public double getCost() {return cost;}


    public void setProduct(String product) { this.product = product; }
    public void setProduct_code(int product_code) { this.product_code = product_code; }
    public void setSupply(int supply) { this.supply= supply; }
    public void setProvider(String provider) { this.provider = provider; }
    public void setDate(String date) { this.date = date; }
    public void setCost(double cost) { this.cost = cost; }

    public void escrever_supplies(String filename) throws Exception {
        File file = new File(filename);
        Workbook workbook = Workbook.getWorkbook(file);
        Sheet supplies = workbook.getSheet(3);
        Sheet products = workbook.getSheet(2);

        Cell c = supplies.getCell(6,0);
        String quant = c.getContents();
        int quantidade = Integer.parseInt(quant);

        int trocarcodigo;
        if (this.product_code != -1){
            trocarcodigo = this.product_code;
        }
        else{
            trocarcodigo = returnproduct(products, this.product);
        }
        if (trocarcodigo == -1){
            System.out.println("Operacao Cancelada!");
        } else{

        Cell quantity = products.getCell(4,trocarcodigo);
        quant = quantity.getContents();
        int quantidadesdeproduto = Integer.parseInt(quant);

        WritableWorkbook copy = Workbook.createWorkbook(new File(filename), workbook);
        WritableSheet suppliesscopy = copy.getSheet(3);
        WritableSheet productscopy = copy.getSheet(2);

        Label label = new Label(0, quantidade, this.product);
        suppliesscopy.addCell(label);

        Number number = new Number(1, quantidade, this.product_code);
        suppliesscopy.addCell(number);

        number = new Number(2, quantidade, this.supply);
        suppliesscopy.addCell(number);

        label = new Label(3, quantidade, this.provider);
        suppliesscopy.addCell(label);

        number = new Number(4, quantidade, this.cost);
        suppliesscopy.addCell(number);

        label = new Label(5, quantidade, this.date);
        suppliesscopy.addCell(label);

        WritableCell c1 = suppliesscopy.getWritableCell(6, 0);
        quantidade++;
        String novodisponivel = Integer.toString(quantidade);
        modifyData(c1, novodisponivel);

        c1 = productscopy.getWritableCell(4, trocarcodigo);
        quantidadesdeproduto += supply;
        String novaquantidade = Integer.toString(quantidadesdeproduto);
        modifyData(c1, novaquantidade);
        copy.write();
        copy.close();
        }
    }

    private void modifyData(WritableCell cell, String novastring) throws Exception {
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

    private int returnproduct(Sheet p, String pnome){
        int totaldelinhas = p.getRows();
        for (int i = 1; i < totaldelinhas; i++){
            Cell cell = p.getCell(0, i);
            String nome = cell.getContents();
            if(nome.equals(pnome))
                return i;
        }
        return -1;
    }
}
