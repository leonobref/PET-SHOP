package testes;

import java.util.ArrayList;
import java.util.List;

public class DoSale
{
    public static void main(String[] args) {
        String nomeArquivo = "sales_data.xls";
        List<Sales> salesList = new ArrayList<>();

        Sales salesData = new Sales("Ração", 123, 100.0f, 5, "2023-08-11", 90.0f,
                "John", "Leivas", 1);
        salesList.add(salesData);

        Sales salesData2 = new Sales("Ração Premium", 456, 1000.0f, 10, "2023-08-11", 90.0f,
                "Maria", "Joaquina", 1);
        salesList.add(salesData2);

        Sales.createNewFile(nomeArquivo, salesList);

        String productDelete = "123";
        Sales.excluirProduto(nomeArquivo, productDelete);
    }
}