package entities;

import java.io.File;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import java.util.List;

public class sProducts
{
    private String name;
    private String code;
    private String category;
    private int sales;
    private int quantity;
    private double costprice;
    private double saleprice;
    private boolean active;

    public sProducts(){}

    public sProducts(String name, String code, String category, int sales, int quantity, double costprice, double saleprice, boolean active) {
        this.name = name;
        this.code = code;
        this.category = category;
        this.sales = sales;
        this.quantity = quantity;
        this.costprice = costprice;
        this.saleprice = saleprice;
        this.active = active;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getCode(){
        return code;
    }
    public void setCode(String code) {this.code = code;}
    public String getProduct_code() {return code;}
    public String getCategory() {return category;}
    public void setCategory(String category) {this.category = category;}
    public int getSales() {return sales;}
    public void setSales(int sales) {this.sales = sales;}
    public String getQuantity() {return String.valueOf(quantity);}
    public void setQuantity(int quantity) {this.quantity = quantity;}
    public double getCostprice() {return costprice;}
    public void setCostprice(double costprice) {this.costprice = costprice;}
    public String getSaleprice() {return String.valueOf(saleprice);}
    public void setSaleprice(double saleprice) {this.saleprice = saleprice;}
    public String getActive() {return String.valueOf(active);}
    public void setActive(boolean active) {this.active = active;}

    public static void createNewFile(String fileName, List<sProducts> salesList)
    {
        WritableWorkbook workbook = null;

        try{
            File file = new File(fileName);
            workbook = Workbook.createWorkbook(file);
            WritableSheet sheet = workbook.createSheet("Sales", 0);

            String[] headers = {
                    "PRODUCT NAME", "PRODUCT CODE", "CATEGORY", "SALES",
                    "QUANTITY", "COST PRICE", "SALE PRICE", "ACTIVE",
                    "INSERTION DATE", "0"
            };

            for (int i = 0; i < headers.length; i++){
                Label label = new Label(i, 0, headers[i]);
                sheet.addCell(label);
            }

            int row = 1;
            for (sProducts productsData : salesList){
                Label productLabel = new Label(0, row, productsData.getName());
                Label productCodeLabel = new Label(1, row, String.valueOf(productsData.getProduct_code()));
                Label categoryLabel = new Label(2, row, String.valueOf(productsData.getCategory()));
                Label salesLabel = new Label(3, row, String.valueOf(productsData.getQuantity()));
                Label quantityLabel = new Label(4, row, productsData.getQuantity());
                Label costPriceLabel = new Label(5, row, String.valueOf(productsData.getCostprice()));
                Label salePriceLabel = new Label(6, row, productsData.getSaleprice());
                Label activeLabel = new Label(7, row, productsData.getActive());

                sheet.addCell(productLabel);
                sheet.addCell(productCodeLabel);
                sheet.addCell(categoryLabel);
                sheet.addCell(salesLabel);
                sheet.addCell(quantityLabel);
                sheet.addCell(costPriceLabel);
                sheet.addCell(salePriceLabel);
                sheet.addCell(activeLabel);

                row++;
            }

            workbook.write();
            System.out.println("File created: " + fileName);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (workbook != null){
                try {
                    workbook.close();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
