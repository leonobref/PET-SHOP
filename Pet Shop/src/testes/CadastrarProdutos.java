package testes;

import entities.Products;
import entities.Supplies;
import entities.Users;
public class CadastrarProdutos {
    public static void main(String[] args) throws Exception {
        //Products produto = new Products("SHAMPOO", "BANHO", 78.50, 90.50, "20/08/2023");
        //produto.escrever_produtos("Dados Pet Shop.xls");
        //Products produto2 = new Products("SABONETE", "BANHO", 18.50, 30.99, "20/08/2023");
        //produto2.escrever_produtos("Dados Pet Shop.xls");

        //Users usuario = new Users("Carlos", "Danilo", "carlosdanilo@gmail.com", "04/03/2003", "%#8mnu#", "5592981194108", 1, "Pet Dentist", "123.456.789-01");
        //usuario.escrever_usuarios("Dados Pet Shop.xls");

        //usuario.desativarUsuario("Dados Pet Shop.xls");

        Supplies suprimento = new Supplies(1, 20, "Roberto", "20/08/2023", 78.5);
        suprimento.escrever_supplies("Dados Pet Shop.xls");
    }

}