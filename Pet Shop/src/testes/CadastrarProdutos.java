package testes;

import entities.Products;

public class CadastrarProdutos {
    public static void main(String[] args) throws Exception {
        Products produto = new Products("SHAMPOO", "BANHO", 78.50, 90.50, "20/08/2023");
        produto.escrever_produtos();
        Products produto2 = new Products("SABONETE", "BANHO", 18.50, 30.99, "20/08/2023");
        produto2.escrever_produtos();
    }

}