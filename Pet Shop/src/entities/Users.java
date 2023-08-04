package usuarioteste1;

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
    		File file = new File(nomeDoArquivo);
    		if (file.exists()) {
                System.out.println("O arquivo " + nomeDoArquivo + " já existe.");
                return; // Aqui você pode decidir o que fazer em caso de arquivo já existente.
            }
            // Criar um arquivo Excel e uma planilha
            WritableWorkbook workbook = Workbook.createWorkbook(file);
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
    public void cadastrarUsuario() {
        try {
            File file = new File("C:/eclipse-workspace/usuarioteste1/arquivo1_excel.xls");
            Workbook workbook = Workbook.getWorkbook(file);
            WritableWorkbook copy = Workbook.createWorkbook(file, workbook);
            WritableSheet usuarioSheet = copy.getSheet(0); // Assumindo que a planilha que queremos usar é a primeira (índice 0)

            int quantidadeUsuarios = usuarioSheet.getRows(); // Obter o número de linhas (usuários) já cadastrados

            Label nomeLabel = new Label(0, quantidadeUsuarios, getName());
            usuarioSheet.addCell(nomeLabel);

            Label complementoLabel = new Label(1, quantidadeUsuarios, getNamecomplement());
            usuarioSheet.addCell(complementoLabel);

            Label emailLabel = new Label(2, quantidadeUsuarios, getEmail());
            usuarioSheet.addCell(emailLabel);

            Label dataLabel = new Label(3, quantidadeUsuarios, getDate());
            usuarioSheet.addCell(dataLabel);

            Label senhaLabel = new Label(4, quantidadeUsuarios, getPassword());
            usuarioSheet.addCell(senhaLabel);

            Label numeroLabel = new Label(5, quantidadeUsuarios, getNumber());
            usuarioSheet.addCell(numeroLabel);

            Label adminLabel = new Label(6, quantidadeUsuarios, getAdmin().toString());
            usuarioSheet.addCell(adminLabel);

            Label ativoLabel = new Label(7, quantidadeUsuarios, getActive().toString());
            usuarioSheet.addCell(ativoLabel);

            Label cargoLabel = new Label(8, quantidadeUsuarios, getJob());
            usuarioSheet.addCell(cargoLabel);

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
            Workbook workbook = Workbook.getWorkbook(file);
            WritableWorkbook copy = Workbook.createWorkbook(file, workbook);
            WritableSheet usuarioSheet = copy.getSheet(0); // Assumindo que a planilha que queremos usar é a primeira (índice 0)

            int totalLinhas = usuarioSheet.getRows();
            int linhaExclusao = -1;

            String emailUsuario = getEmail(); // Usando o getter para obter o email do próprio objeto Users

            // Procurar o usuário na planilha pelo email
            for (int i = 1; i < totalLinhas; i++) {
                Cell cell = usuarioSheet.getCell(2, i); // Coluna 2 contém os emails
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
}
