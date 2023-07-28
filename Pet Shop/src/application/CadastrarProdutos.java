package application;

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
        File file = new File("C:/Users/leono/OneDrive/Desktop/UEA/2023.1/Projeto de Programas/Arquivos/Dados Pet Shop.xls");
        Workbook workbook = Workbook.getWorkbook(file);
        Sheet products = workbook.getSheet(2);

        Cell c0 = products.getCell(10,0);
        String disp = c0.getContents();
        int disponivel = Integer.parseInt(disp);
        Cell c = products.getCell(9,0);
        String quant = c.getContents();
        int quantidade = Integer.parseInt(quant);


        WritableWorkbook copy = Workbook.createWorkbook(new File("C:/Users/leono/OneDrive/Desktop/UEA/2023.1/Projeto de Programas/Arquivos/Dados Pet Shop.xls"), workbook);
        WritableSheet productscopy = copy.getSheet(2);


        Label label = new Label(0, disponivel, "SHAMPOO");
        productscopy.addCell(label);

        Number number = new Number(1, disponivel, 3);
        productscopy.addCell(number);

        Label label2 = new Label(2, disponivel, "BANHO");
        productscopy.addCell(label2);

        Number number2 = new Number(3, disponivel, 0);
        productscopy.addCell(number2);

        Number number3 = new Number(4, disponivel, 0);
        productscopy.addCell(number3);

        Number number4 = new Number(5, disponivel, 65);
        productscopy.addCell(number4);

        Number number5 = new Number(6, disponivel, 80);
        productscopy.addCell(number5);

        Number number6 = new Number(7, disponivel, 1);
        productscopy.addCell(number6);

        WritableCell c1 = productscopy.getWritableCell(10, 0);
        disponivel++;
        String novodisponivel = Integer.toString(disponivel);
        modifyData(c1, novodisponivel);

        quantidade++;
        WritableCell c2 = productscopy.getWritableCell(9, 0);
        String novaquantidade = Integer.toString(quantidade);
        modifyData(c2, novaquantidade);

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