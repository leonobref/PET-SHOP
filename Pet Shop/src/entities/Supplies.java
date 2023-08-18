package entities;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.File;
import java.util.List;

public class Supplies
{
    private String product;
    private int product_code;
    private float supply;
    private int provider;
    private String date;
    private float cost;

    // Construtores
    public Supplies() {}

    public Supplies(String product, int product_code, float supply, int provider, String date, float cost)
    {
        this.product = product;
        this.product_code = product_code;
        this.supply = supply;
        this.provider = provider;
        this.date = date;
        this.cost = cost;
    }

    // Getters e Setters
    public String getProduct() { return product; }
    public int getProduct_code() { return product_code; }
    public float getSupply() { return supply; }
    public int getProvider() {return provider;}
    public String getDate() { return date; }
    public float getCost() {return cost;}


    public void setProduct(String product) { this.product = product; }
    public void setProduct_code(int product_code) { this.product_code = product_code; }
    public void setSupply(float supply) { this.supply= supply; }
    public void setProvider(int provider) { this.provider = provider; }
    public void setDate(String date) { this.date = date; }
    public void setCost(float cost) { this.cost = cost; }

    public static void createNewFile(String fileName, List<Supplies> suppliesList)
    {
        WritableWorkbook workbook = null;

        try {
            File file = new File(fileName);

            // Criando arquivo e planilha
            workbook = Workbook.createWorkbook(file);
            WritableSheet sheet = workbook.createSheet("Supplies", 0);

            String[] headers = {
                    "PRODUCT", "PRODUCT CODE", "SUPPLY", "PROVIDER",
                    "DATE", "COST", "0"
            };

            for (int i = 0; i < headers.length; i++) {
                Label label = new Label(i, 0, headers[i]);
                sheet.addCell(label);
            }

            int row = 1;
            for (Supplies suppliesData : suppliesList) {
                Label productLabel = new Label(0, row, suppliesData.getProduct());
                Label productCodeLabel = new Label(1, row, String.valueOf(suppliesData.getProduct_code()));
                Label supplyLabel = new Label(2, row, String.valueOf(suppliesData.getSupply()));
                Label providerLabel = new Label(3, row, String.valueOf(suppliesData.getProvider()));
                Label dateLabel = new Label(4, row, suppliesData.getDate());
                Label costLabel = new Label(5, row, String.valueOf(suppliesData.getCost()));

                sheet.addCell(productLabel);
                sheet.addCell(productCodeLabel);
                sheet.addCell(supplyLabel);
                sheet.addCell(providerLabel);
                sheet.addCell(dateLabel);
                sheet.addCell(costLabel);

                row++;
            }

            workbook.write();
            System.out.println("File created: " + fileName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (workbook != null) {
                try {
                    workbook.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
