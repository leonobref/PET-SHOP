package entities;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
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

    public void escreverDadosEmExcel(String nomeDoArquivo) 
    {
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

    private void createSheet(WritableWorkbook workbook, String sheetName, String... headers) throws WriteException {
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
    public void verifyExistenceDate() {
        String fileName = "DadosPetShop.xls";
        File file = new File(fileName);

        if (!file.exists()) {
            escreverDadosEmExcel(fileName);
            System.out.println("Arquivo " + fileName + " criado com sucesso!");
        } else {
            System.out.println("O arquivo " + fileName + " já existe.");
        }
    }
}