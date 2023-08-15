package testes;
import entities.Sales;
public class DoSale
{
    public static void main(String[] args) {
        String nomeArquivo = "sales_data.xls";

        Sales salesData = new Sales("Ração", 123, 100.0f, 5, "2023-08-11", 90.0f,
                "John", "Leivas", 1);

        Sales.createNewFile(nomeArquivo, salesData);
    }
}
