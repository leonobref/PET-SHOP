package entities;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import java.util.Date;
import java.text.SimpleDateFormat;

public class TesteProducts {
    public static void main(String[] args) {
        try {
            String fileName = "DadosPetShop.xls";

            // Criar um produto de teste
            Products testProduct = new Products();
            testProduct.setName("Ração do BRABO");
            testProduct.setCategory("Comida");   
            testProduct.setQuantity(10);
            testProduct.setCostprice(10.0);
            testProduct.setSaleprice(20.0);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String insertionDate = dateFormat.format(new Date());
            testProduct.setInsertiondate(insertionDate);

            // Adicionar o produto de teste na planilha "Products"
            testProduct.escrever_produtos(fileName);

            System.out.println("Produto de teste adicionado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}