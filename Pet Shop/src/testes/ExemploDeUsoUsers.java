package testes;
import entities.Users;
import java.io.File;
public class ExemploDeUsoUsers {

    public static void main(String[] args) {
        String nomeDoArquivo = "arquivo1_excel.xls";

        // Criar um objeto Users com dados do usuário
        Users user = new Users();
        user.setName("João da Silva");
        user.setNamecomplement("Complemento do nome");
        user.setEmail("joao@example.com");
        user.setDate("01/01/1985");
        user.setPassword("senha123");
        user.setNumber("1234567890");
        user.setAdmin(1);
        user.setActive(1);
        user.setCPF("578.986.677-86");
        user.setJob("Desenvolvedor");

        // Escrever os dados do usuário no arquivo Excel
        user.escreverDadosEmExcel(nomeDoArquivo);
    }
}