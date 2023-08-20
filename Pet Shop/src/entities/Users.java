package entities;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.CellType;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.Number;

public class Users {
    private String name;
    private String namecomplement;
    private int code;
    private String email;
    private String date;
    private String password;
    private String number;
    private int admin;
    private int active;
    private String job;
    private String CPF;
    public Users() {
    }

    public Users(String name, String namecomplement,String email, String date, String password, String number,
            int admin, String job,String CPF) {
        this.name = name;
        this.namecomplement = namecomplement;
        this.email = email;
        this.date = date;
        this.password = password;
        this.number = number;
        this.admin = admin;
        this.CPF = CPF;
        this.active = 1;
        this.job = job;
    }

    public String getCPF() {
    	return CPF;
    }
    public void setCPF(String CPF) {
    	this.CPF=CPF;
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

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void escrever_usuarios(String filename) throws Exception{
        File file = new File(filename);
        Workbook workbook = Workbook.getWorkbook(file);
        Sheet users = workbook.getSheet(0);

        Cell c = users.getCell(11, 0);
        String quant = c.getContents();
        int quantidade = Integer.parseInt(quant);

        WritableWorkbook copy = Workbook.createWorkbook(new File(filename), workbook);
        WritableSheet userscopy = copy.getSheet(0);

        Label label = new Label(0, quantidade, this.name);
        userscopy.addCell(label);

        label = new Label(1, quantidade, this.namecomplement);
        userscopy.addCell(label);

        Number number = new Number(2, quantidade, quantidade);
        userscopy.addCell(number);

        label = new Label(3, quantidade, this.email);
        userscopy.addCell(label);

        label = new Label(4, quantidade, this.date);
        userscopy.addCell(label);

        label = new Label(5, quantidade, this.password);
        userscopy.addCell(label);

        label = new Label(6, quantidade, this.number);
        userscopy.addCell(label);

        number = new Number(7, quantidade, this.admin);
        userscopy.addCell(number);

        number = new Number(8, quantidade, 1);
        userscopy.addCell(number);

        label = new Label(9, quantidade, this.job);
        userscopy.addCell(label);

        label = new Label(10, quantidade, this.CPF);
        userscopy.addCell(label);

        WritableCell c1 = userscopy.getWritableCell(11, 0);
        quantidade++;
        String novodisponivel = Integer.toString(quantidade);
        modifyData(c1, novodisponivel);

        copy.write();
        copy.close();
    }
    private void modifyData(WritableCell cell, String novastring) throws Exception {
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
    public void desativarUsuario(String nomeDoArquivo) {
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
                WritableCell c1 = usuarioSheet.getWritableCell(8, linhaExclusao);
                modifyData(c1, "0");
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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    //???????????????????????????????
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
