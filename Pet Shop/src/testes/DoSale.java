package testes;
import entities.Sales;
public class DoSale
{
    public static void main(String[] args) {
        String nomeArquivo = "sales_data.xls"; // Nome do arquivo que você deseja criar

        // Dados de exemplo
        Sales salesData = new Sales("Sample Product", 123, 100.0f, 5, "2023-08-11", 90.0f,
                "John", "Doe", 1);

        // Criar novo arquivo XLS com os dados fornecidos
        Sales.criarNovoArquivo(nomeArquivo, salesData);
    }
}
