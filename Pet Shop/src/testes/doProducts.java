package testes;

import entities.sProducts;
import java.util.ArrayList;
import java.util.List;

public class doProducts{
    public static void main(String[] args){
        String nomeArquivo = "product_data.xls";
        List<sProducts> productList = new ArrayList<>();

        sProducts p1 = new sProducts("Ração Pedigree", "123", "A", 20, 10, 400, 500, true);
        productList.add(p1);

        sProducts p2 = new sProducts("Ração Bernafon", "456", "B", 20, 10, 150, 120, true);
        productList.add(p2);

        sProducts.createNewFile("product_data.xls", productList);
    }
}
