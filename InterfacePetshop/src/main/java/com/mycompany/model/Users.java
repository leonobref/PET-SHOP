package com.mycompany.model;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.CellType;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import com.mycompany.model.Utils;
import jxl.write.biff.RowsExceededException;

public class Users {
    private String name;
    private String namecomplement;
    private String email;
    private String date;
    private String password;
    private String number;
    private String admin;
    private String active;
    private String job;
    private String Employment;
    private String CPF;
    private String prox;
    public Users() {
    }

    public Users(String name, String namecomplement,String Employment,String email, String date, String password, String number,
            String admin, String active, String job,String CPF ,String prox) {
        this.name = name;
        this.namecomplement = namecomplement;
        this.Employment = Employment;
        this.email = email;
        this.date = date;
        this.password = password;
        this.number = number;
        this.admin = admin;
        this.CPF = CPF;
        this.prox=prox;
        this.active = active;
        this.job = job;
    }
    public String getprox() {
    	return prox;
    }
    public void setprox(String prox) {
    	this.prox=prox;
    }
    public String getCPF() {
    	return CPF;
    }
    public void setCPF(String CPF) {
    	this.CPF=CPF;
    }
    public String getEmployment() {
    	return Employment;
    }
    public void setEmployment(String Employment) {
    	this.Employment= Employment;
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

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void cadastrarUsuario()
    {
        try {

            //Utils.verifyExistenceDate();

            File file = new File(Utils.findDataFile());
            Workbook workbook = Workbook.getWorkbook(file);
            WritableWorkbook copy = Workbook.createWorkbook(file, workbook);
            WritableSheet usuarioSheet = copy.getSheet(0); // Assumindo que a planilha que queremos usar é a primeira (índice 0)

            int quantidadeUsuarios = usuarioSheet.getRows(); // Obter o número de linhas (usuários) já cadastrados

            Label nomeLabel = new Label(0, quantidadeUsuarios, getName());
            usuarioSheet.addCell(nomeLabel);

            Label complementoLabel = new Label(1, quantidadeUsuarios, getNamecomplement());
            usuarioSheet.addCell(complementoLabel);
            
            Label EmploymentLabel = new Label(2, quantidadeUsuarios, getEmployment());
            usuarioSheet.addCell(EmploymentLabel);

            Label emailLabel = new Label(3, quantidadeUsuarios, getEmail());
            usuarioSheet.addCell(emailLabel);

            Label dataLabel = new Label(4, quantidadeUsuarios, getDate());
            usuarioSheet.addCell(dataLabel);

            Label senhaLabel = new Label(5, quantidadeUsuarios, getPassword());
            usuarioSheet.addCell(senhaLabel);

            Label numeroLabel = new Label(6, quantidadeUsuarios, getNumber());
            usuarioSheet.addCell(numeroLabel);

            Label adminLabel = new Label(7, quantidadeUsuarios, getAdmin());
            usuarioSheet.addCell(adminLabel);

            Label ativoLabel = new Label(8, quantidadeUsuarios, getActive());
            usuarioSheet.addCell(ativoLabel);

            Label cargoLabel = new Label(9, quantidadeUsuarios, getJob());
            usuarioSheet.addCell(cargoLabel);
            
            Label CPFLabel = new Label(10, quantidadeUsuarios, getCPF());
            usuarioSheet.addCell(CPFLabel);
            
            Label proxLabel = new Label(11, quantidadeUsuarios, getprox());
            usuarioSheet.addCell(proxLabel);

            // Atualizar a célula que guarda a quantidade de usuários cadastrados
            WritableCell c1 = usuarioSheet.getWritableCell(0, 0);
            c1 = new Label(0, 0, Integer.toString(quantidadeUsuarios));
            modifyData(c1, Integer.toString(quantidadeUsuarios));

            copy.write();
            copy.close();

            System.out.println("Usuário cadastrado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void modifyData(WritableCell cell, String novastring) throws Exception {
        if (cell.getType() == CellType.LABEL) {
            Label l = (Label) cell;
            l.setString(novastring);
        } else if (cell.getType() == CellType.NUMBER) {
            Label n = (Label) cell;
            n.setString(novastring);
        } else {
            System.out.println("Other data... ");
        }
    }
    public void excluirUsuario(String nomeDoArquivo) {
        try {
            File file = new File(nomeDoArquivo);
    		if (!file.exists()) {
                System.out.println("O arquivo " + nomeDoArquivo + " não existe.");
                return; // Aqui você pode decidir o que fazer em caso de arquivo já existente.
            }
            Workbook workbook = Workbook.getWorkbook(file);
            WritableWorkbook copy = Workbook.createWorkbook(file, workbook);
            WritableSheet usuarioSheet = copy.getSheet(0); // Assumindo que a planilha que queremos usar é a primeira (índice 0)

            int totalLinhas = usuarioSheet.getRows();
            int linhaExclusao = -1;

            String emailUsuario = getEmail(); // Usando o getter para obter o email do próprio objeto Users

            // Procurar o usuário na planilha pelo email
            for (int i = 1; i < totalLinhas; i++) {
                Cell cell = usuarioSheet.getCell(3, i); // Coluna 2 contém os emails
                String email = cell.getContents();
                if (email.equals(emailUsuario)) {
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

    public void mudarNomeArquivo(String nomeAntigo, String nomeNovo) {
        File arquivoAntigo = new File(nomeAntigo);
        
        if (arquivoAntigo.exists()) {
            File arquivoNovo = new File(nomeNovo);
            
            if (arquivoAntigo.renameTo(arquivoNovo)) {
                System.out.println("Nome do arquivo alterado com sucesso.");
            } else {
                System.out.println("Não foi possível alterar o nome do arquivo.");
            }
        } else {
            System.out.println("O arquivo " + nomeAntigo + " não existe.");
        }
    }
}
