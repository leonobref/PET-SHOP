package entities;

import java.io.File;
import java.io.IOException;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Costumers
{
    private String name;
    private String last_name;
    private String email;
    private String cpf;
    private String number;
    private String orders;
    private String code;
    
    // Construtores
    public Costumers() {}

    public Costumers(String name, String last_name, String email, String cpf, String number, String orders, String code)
    {
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.cpf = cpf;
        this.number = number;
        this.orders = orders;
        this.code = code;

    }

    // Getters e Setters

    public String getOrders() { return orders; }
    public String getEmail() { return email; }

    public String getLast_name() { return last_name; }
    public String getCpf() { return cpf; }
    public String getCode() { return code; }
    public String getNumber() { return number; }
    public String getName() { return name; }

    public void setOrders(String orders) {this.orders = orders;}
    public void setEmail(String email) {this.email = email;}
    public void setLast_name(String Last_name) { this.last_name = last_name; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public void setCode(String code) { this.code = code; }
    public void setNumber(String Number) { this.number = number; }
    public void setName(String name) { this.name = name; }


    public static void criarNovoArquivo(String nomeArquivo, Costumers salesData) {
        WritableWorkbook workbook = null;

        try {
            // Verificar se o arquivo já existe
            File arquivo = new File(nomeArquivo);

            if (!arquivo.exists()) {
                // Criando o novo arquivo
                workbook = Workbook.createWorkbook(arquivo);
                WritableSheet sheet = workbook.createSheet("Sales", 0);

                String[] headers = {
                        "NAME", "LAST NAME", "CPF", "CPF",
                        "NUMBER", "ORDERS", "CODE",  "0", "0"
                };

                for (int i = 0; i < headers.length; i++) {
                    Label label = new Label(i, 0, headers[i]);
                    sheet.addCell(label);
                }

                Label productLabel = new Label(0, 1, salesData.getName());
                Label productCodeLabel = new Label(1, 1, String.valueOf(salesData.getLast_name()));
                Label valueLabel = new Label(2, 1, String.valueOf(salesData.getEmail()));
                Label quantityLabel = new Label(3, 1, String.valueOf(salesData.getCpf()));
                Label dateLabel = new Label(4, 1, salesData.getNumber());
                Label saleLabel = new Label(5, 1, String.valueOf(salesData.getOrders()));
                Label customerNameLabel = new Label(6, 1, salesData.getCode());


                sheet.addCell(productLabel);
                sheet.addCell(productCodeLabel);
                sheet.addCell(valueLabel);
                sheet.addCell(quantityLabel);
                sheet.addCell(dateLabel);
                sheet.addCell(saleLabel);
                sheet.addCell(customerNameLabel);

                workbook.write();
                System.out.println("Arquivo criado: " + nomeArquivo);
            } else {
                System.out.println("Arquivo já existe: " + nomeArquivo);
            }

            System.out.println("Dados escritos no arquivo Excel com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (workbook != null) {
                try {
                    workbook.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
