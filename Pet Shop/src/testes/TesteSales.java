package entities;

import java.util.Date;
import java.text.SimpleDateFormat;

public class TesteSales {
    public static void main(String[] args) {
        try {
            String fileName = "DadosPetShop.xls";

            // Criar uma venda de teste
            Sales testSale = new Sales();
            testSale.setProduct("Ração  do Brabo");
            testSale.setProduct_code("8"); // Código de produto válido da planilha "Products"
            testSale.setValue(50.0f);
            testSale.setQuantity(3);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String saleDate = dateFormat.format(new Date());
            testSale.setDate(saleDate);
            testSale.setSale(60.0f);
            testSale.setCustomer_name("Cliente");
            testSale.setCustomer_last_name("Teste");
            testSale.setCustomer_code(456); // Código de cliente válido

            // Adicionar a venda de teste na planilha "Sales"
            Sales.adicionarVenda(fileName, testSale);

            System.out.println("Venda de teste adicionada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}