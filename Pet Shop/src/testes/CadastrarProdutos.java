package testes;

import java.io.IOException;

import java.util.Date;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jxl.CellType;
import jxl.write.*;
import jxl.Cell;
import jxl.Workbook;
import jxl.Sheet;
import jxl.read.biff.BiffException;
import jxl.write.Number;


public class CadastrarProdutos {
    public static void main(String[] args) throws Exception {
        File file = new File("Dados Pet Shop.xls");
        Workbook workbook = Workbook.getWorkbook(file);
        Sheet products = workbook.getSheet(2);

        Cell c = products.getCell(9,0);
        String quant = c.getContents();
        int quantidade = Integer.parseInt(quant);


        WritableWorkbook copy = Workbook.createWorkbook(new File("Dados Pet Shop.xls"), workbook);
        WritableSheet productscopy = copy.getSheet(2);


        Label label = new Label(0, quantidade +1, "SHAMPOO");
        productscopy.addCell(label);

        Number number = new Number(1, quantidade + 1, 3);
        productscopy.addCell(number);

        Label label2 = new Label(2, quantidade +1, "BANHO");
        productscopy.addCell(label2);

        Number number2 = new Number(3, quantidade +1, 0);
        productscopy.addCell(number2);

        Number number3 = new Number(4, quantidade +1, 0);
        productscopy.addCell(number3);

        Number number4 = new Number(5,quantidade +1, 65);
        productscopy.addCell(number4);

        Number number5 = new Number(6, quantidade +1, 80);
        productscopy.addCell(number5);

        Number number6 = new Number(7, quantidade +1, 1);
        productscopy.addCell(number6);

        number = new Number(0, 1000, 567);
        productscopy.addCell(number);

        WritableCell c1 = productscopy.getWritableCell(9, 0);
        quantidade++;
        String novodisponivel = Integer.toString(quantidade);
        modifyData(c1, novodisponivel);

        copy.write();
        copy.close();
    }
    public static void modifyData(WritableCell cell, String novastring) throws Exception {
        double numero = Double.parseDouble(novastring);
        if (cell.getType() == CellType.LABEL) {
            Label l = (Label) cell;
            l.setString(novastring);
        } else if (cell.getType() == CellType.NUMBER) {
            Number n = (Number) cell;
            n.setValue(numero);
        } else {
            System.out.println("Other data... ");
        }
    }
}