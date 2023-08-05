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
        user.setAdmin(false);
        user.setActive(true);
        user.setJob("Desenvolvedor");

        // Escrever os dados do usuário no arquivo Excel
        user.escreverDadosEmExcel(nomeDoArquivo);
    }
}