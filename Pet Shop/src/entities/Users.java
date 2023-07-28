package entities;

import java.io.File;
import java.io.IOException;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Users {
    private String name;
    private String namecomplement;
    private String email;
    private String date;
    private String password;
    private String number;
    private Boolean admin;
    private Boolean active;
    private String job;

    public Users() {
    }

    public Users(String name, String namecomplement, String email, String date, String password, String number,
                 Boolean admin, Boolean active, String job) {
        this.name = name;
        this.namecomplement = namecomplement;
        this.email = email;
        this.date = date;
        this.password = password;
        this.number = number;
        this.admin = admin;
        this.active = active;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamecomplement() {
        return namecomplement;
    }

    public void setNamecomplement(String namecomplement) {
        this.namecomplement = namecomplement;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void escreverDadosEmExcel(String nomeDoArquivo) {
        try {
            // Criar um arquivo Excel e uma planilha
            WritableWorkbook workbook = Workbook.createWorkbook(new File(nomeDoArquivo));
            WritableSheet sheet = workbook.createSheet("Planilha1", 0);

            // Escrever dados na planilha
            Label label = new Label(0, 0, "Nome");
            sheet.addCell(label);

            label = new Label(1, 0, "Nome Complemento");
            sheet.addCell(label);

            label = new Label(2, 0, "E-mail");
            sheet.addCell(label);

            label = new Label(3, 0, "Data");
            sheet.addCell(label);

            label = new Label(4, 0, "Senha");
            sheet.addCell(label);

            label = new Label(5, 0, "Número");
            sheet.addCell(label);

            label = new Label(6, 0, "Admin");
            sheet.addCell(label);

            label = new Label(7, 0, "Ativo");
            sheet.addCell(label);

            label = new Label(8, 0, "Cargo");
            sheet.addCell(label);

            // Escrever os dados do usuário na planilha
            int row = 1;
            Label dataLabel = new Label(0, row, getName());
            sheet.addCell(dataLabel);

            dataLabel = new Label(1, row, getNamecomplement());
            sheet.addCell(dataLabel);

            dataLabel = new Label(2, row, getEmail());
            sheet.addCell(dataLabel);

            dataLabel = new Label(3, row, getDate());
            sheet.addCell(dataLabel);

            dataLabel = new Label(4, row, getPassword());
            sheet.addCell(dataLabel);

            dataLabel = new Label(5, row, getNumber());
            sheet.addCell(dataLabel);

            dataLabel = new Label(6, row, getAdmin().toString());
            sheet.addCell(dataLabel);

            dataLabel = new Label(7, row, getActive().toString());
            sheet.addCell(dataLabel);

            dataLabel = new Label(8, row, getJob());
            sheet.addCell(dataLabel);

            // Salvar o arquivo Excel
            workbook.write();
            workbook.close();

            System.out.println("Dados escritos no arquivo Excel com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}