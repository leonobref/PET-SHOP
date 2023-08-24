package com.mycompany.model;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
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

    public void  escreverDadosEmExcel() {
    	try {
    		// Manter Um nome pAdrão
    	File file = new File("Pet Shop Dados.xls");
    		if (file.exists()) {
                System.out.println("O arquivo " + file + " já existe.");
                return ; // Aqui você pode decidir o que fazer em caso de arquivo já existente.
            }
            // Criar um arquivo Excel e uma planilha
            WritableWorkbook workbook = Workbook.createWorkbook(file);
            WritableSheet sheet = workbook.createSheet("Users", 0);
            
            // Escrever dados na planilha
            Label label = new Label(0, 0, "NAME");
            sheet.addCell(label);

            label = new Label(1, 0, "NAME COMPLEMENT");
            sheet.addCell(label);
            
            label = new Label(2, 0, "EMPLOYMENT CODE");
            sheet.addCell(label);
            
            label = new Label(3, 0, "E-mail");
            sheet.addCell(label);

            label = new Label(4, 0, "Data");
            sheet.addCell(label);

            label = new Label(5, 0, "Senha");
            sheet.addCell(label);

            label = new Label(6, 0, "Número");
            sheet.addCell(label);

            label = new Label(7, 0, "Admin");
            sheet.addCell(label);

            label = new Label(8, 0, "Ativo");
            sheet.addCell(label);

            label = new Label(9, 0, "Cargo");
            sheet.addCell(label);
            
            label = new Label(10, 0, "CPF");
            sheet.addCell(label);
            
            label = new Label(11, 0, "PROX");
            sheet.addCell(label);

            

            // Salvar o arquivo Excel
            workbook.write();
            workbook.close();

            System.out.println("Dados escritos no arquivo Excel com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ;
    }
    //Função recebe um path personalizado
    public void cadastrarUsuario() {
        try {
            File file = new File("Pet Shop Dados.xls");
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
            WritableCell c1 = usuarioSheet.getWritableCell(12, 1);
            c1 = new Label(0, 0, Integer.toString(quantidadeUsuarios));
            

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
         
       
            Label n = (Label) cell;
            n.setString(novastring);
       
            System.out.println(" Usuario Alterado ");
        }
    
        
        
    
    public void excluirUsuario() throws IOException, BiffException, WriteException {
        
            File file = new File("Pet Shop Dados.xls");
            
            //Criar uma Planilha editável
            Workbook file1 = Workbook.getWorkbook(file);
            WritableWorkbook writeBook =Workbook.createWorkbook(file,file1);
            WritableSheet usersheet = writeBook.getSheet(0);
            
            int linhaExclusao = -1;
            
            //Procurar Por nome e Saber a Linha
            String nome = getName();
            for(int i = 0;i < usersheet.getRows();i++){
                if(nome.equals(usersheet.getCell(0,i).getContents())){
                    linhaExclusao = i;
                }
            }
            
            //Excluindo
            if(linhaExclusao != -1){
               usersheet.removeRow(linhaExclusao);
            }
            
            //Escrevendo e fechando//
            writeBook.write();
            writeBook.close();
            
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
