package entities;

import java.io.File;
import java.io.IOException;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import java.util.List;

public class Sales
{
    private String product;
    private int product_code;
    private float value;
    private int quantity;
    private String date;
    private float sale;
    private String customer_name;
    private String customer_last_name;
    private int customer_code;

    // Construtores
    public Sales() {}

    public Sales(String product, int product_code, float value, int quantity, String date, float sale, String customer_name,
                 String customer_last_name, int customer_code)
    {
        this.product = product;
        this.product_code = product_code;
        this.value = value;
        this.quantity = quantity;
        this.date = date;
        this.sale = sale;
        this.customer_name = customer_name;
        this.customer_last_name = customer_last_name;
        this.customer_code = customer_code;
    }

    // Getters e Setters

    public float getSale() { return sale; }
    public float getValue() { return value; }
    public int getCustomer_code() { return customer_code; }
    public int getProduct_code() { return product_code; }
    public int getQuantity() { return quantity; }
    public String getCustomer_last_name() { return customer_last_name; }
    public String getCustomer_name() { return customer_name; }
    public String getDate() { return date; }
    public String getProduct() { return product; }

    public void setCustomer_code(int customer_code) { this.customer_code = customer_code; }
    public void setCustomer_last_name(String customer_last_name) { this.customer_last_name = customer_last_name; }
    public void setCustomer_name(String customer_name) { this.customer_name = customer_name; }
    public void setDate(String date) { this.date = date; }
    public void setProduct(String product) { this.product = product; }
    public void setProduct_code(int product_code) { this.product_code = product_code; }
    public void setSale(float sale) { this.sale = sale; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setValue(float value) { this.value = value; }

    public static void createNewFile(String fileName, List<Sales> salesList) {
        WritableWorkbook workbook = null;

        try {
            File file = new File(fileName);
            workbook = Workbook.createWorkbook(file);
            WritableSheet sheet = workbook.createSheet("Sales", 0);

            String[] headers = {
                    "PRODUCT", "PRODUCT CODE", "VALUE", "QUANTITY",
                    "DATE", "SALE", "CUSTOMER NAME", "CUSTOMER LAST NAME",
                    "CUSTOMER CODE", "0"
            };

            for (int i = 0; i < headers.length; i++) {
                Label label = new Label(i, 0, headers[i]);
                sheet.addCell(label);
            }

            int row = 1; // Start from the second row
            for (Sales salesData : salesList) {
                Label productLabel = new Label(0, row, salesData.getProduct());
                Label productCodeLabel = new Label(1, row, String.valueOf(salesData.getProduct_code()));
                Label valueLabel = new Label(2, row, String.valueOf(salesData.getValue()));
                Label quantityLabel = new Label(3, row, String.valueOf(salesData.getQuantity()));
                Label dateLabel = new Label(4, row, salesData.getDate());
                Label saleLabel = new Label(5, row, String.valueOf(salesData.getSale()));
                Label customerNameLabel = new Label(6, row, salesData.getCustomer_name());
                Label customerLastNameLabel = new Label(7, row, salesData.getCustomer_last_name());
                Label customerCodeLabel = new Label(8, row, String.valueOf(salesData.getCustomer_code()));

                sheet.addCell(productLabel);
                sheet.addCell(productCodeLabel);
                sheet.addCell(valueLabel);
                sheet.addCell(quantityLabel);
                sheet.addCell(dateLabel);
                sheet.addCell(saleLabel);
                sheet.addCell(customerNameLabel);
                sheet.addCell(customerLastNameLabel);
                sheet.addCell(customerCodeLabel);

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
