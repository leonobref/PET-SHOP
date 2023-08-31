package com.mycompany.model;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Utils {

    public static String findDataFile() {
        String fileName = "DadosPetShop.xls";
        File currentDirectory = new File(System.getProperty("user.dir"));
        File[] files = currentDirectory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().equals(fileName)) {
                    return file.getAbsolutePath();
                }
            }
        }

        return null; // Arquivo não encontrado
    }
    public static void escreverDadosEmExcel(String nomeDoArquivo) {
        try {
            File file = new File(nomeDoArquivo);
            if (file.exists()) {
                System.out.println("O arquivo " + nomeDoArquivo + " já existe.");
                return;
            }

            // Criar um arquivo Excel e planilhas
            WritableWorkbook workbook = Workbook.createWorkbook(file);

            createSheet(workbook, "Users", "NAME", "NAME COMPLEMENT", "EMPLOYMENT CODE", "E-mail", "Data", "Senha",
                    "Número", "Admin", "Ativo", "Cargo", "CPF", "PROX","1");

            createSheet(workbook, "Customers", "NAME", "LAST NAME", "E-mail", "CPF", "NUMBER", "ORDERS", "CODE","1");

            createSheet(workbook, "Products", "PRODUCT NAME", "PRODUCT CODE", "CATEGORY", "SALES", "QUANTITY",
                    "COST PRICE", "SALE PRICE", "ACTIVE", "INSERTION DATE","1");

            createSheet(workbook, "Supplies", "PRODUCT NAME", "PRODUCT CODE", "SUPPLY", "PROVIDER", "COST", "DATE","1");

            createSheet(workbook, "Sales", "PRODUCT", "PRODUCT CODE", "VALUE", "QUANTITY", "DATE", "SALE",
                    "CUSTOMER NAME", "CUSTOMER LAST NAME", "CUSTOMER CODE", "RESP", "RESP CODE","1","1");

            // Salvar o arquivo Excel
            workbook.write();
            workbook.close();

            System.out.println("Dados escritos no arquivo Excel com sucesso!");
        } catch (IOException | WriteException e) {
            e.printStackTrace();
        }
    }

    private static void createSheet(WritableWorkbook workbook, String sheetName, String... headers) throws WriteException {
        WritableSheet sheet = workbook.createSheet(sheetName, workbook.getNumberOfSheets());
        for (int i = 0; i < headers.length; i++) {
            Label label = new Label(i, 0, headers[i]);
            try {
                sheet.addCell(label);
            } catch (RowsExceededException e) {
                e.printStackTrace();
            } catch (WriteException e) {
                e.printStackTrace();
            }
        }
    }

    public static void verifyExistenceDate() {
        String fileName = "DadosPetShop.xls";
        File file = new File(fileName);

        if (!file.exists()) {
            escreverDadosEmExcel(fileName);
            System.out.println("Arquivo " + fileName + " criado com sucesso!");
        } else {
            System.out.println("O arquivo " + fileName + " já existe.");
        }
    }

    public static void excluir(String nomeDoArquivo, int cod, int IDplanilha)
    {
        try {
            File file = new File(nomeDoArquivo);
            if (!file.exists()) {
                System.out.println("O arquivo " + nomeDoArquivo + " não existe.");
                return; // Decide what to do in case the file doesn't exist.
            }

            Workbook workbook = Workbook.getWorkbook(file);
            WritableWorkbook copy = Workbook.createWorkbook(file, workbook);
            WritableSheet produtosSheet = copy.getSheet(IDplanilha); // Assuming the sheet index for products is 2

            int totalLinhas = produtosSheet.getRows();
            int linhaExclusao = -1;

            String CodProduto = String.valueOf(cod); // Assuming there is a getter for the product name

            // Search for the product in the sheet by its name
            for (int i = 1; i < totalLinhas; i++) {
                Cell cell = produtosSheet.getCell(1, i); // Column 0 contains the product names
                String code = cell.getContents();
                if (code.equals(CodProduto)) {
                    linhaExclusao = i;
                    break;
                }
            }

            if (linhaExclusao != -1) {
                // Found the product by name and now let's remove the row
                produtosSheet.removeRow(linhaExclusao);
                copy.write();
                copy.close();
                System.out.println("Produto excluído com sucesso!");
            } else {
                System.out.println("Produto não encontrado na planilha.");
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
