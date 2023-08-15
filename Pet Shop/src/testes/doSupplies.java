package testes;

import entities.Supplies;

import java.util.ArrayList;
import java.util.List;

public class doSupplies
{
    public static void main(String[] args)
    {
        String nomeArquivo = "supplies_data.xls";
        List<Supplies> suppliesList = new ArrayList<>();

        Supplies suppliesData = new Supplies("Ração",1,1,0,"15082023",12);
        suppliesList.add(suppliesData);

        Supplies suppliesData2 = new Supplies("Veneno",2,2,0,"16082023",10);
        suppliesList.add(suppliesData2);

        Supplies.createNewFile("supplies_data.xls", suppliesList);
    }
}
