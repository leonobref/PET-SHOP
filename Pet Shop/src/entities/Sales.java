package entities;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

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
    public Sales () {}

    public Sales (String product, int product_code, float value, int quantity, String date, float sale, String customer_name,
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

    // Getters

    public float getSale() {return sale;}
    public float getValue() {return value;}
    public int getCustomer_code() {return customer_code;}
    public int getProduct_code() {return product_code;}
    public int getQuantity() {return quantity;}
    public String getCustomer_last_name() {return customer_last_name;}
    public String getCustomer_name() {return customer_name;}
    public String getDate() {return date;}
    public String getProduct() {return product;}

    // Setters

    public void setCustomer_code(int customer_code) {this.customer_code = customer_code;}
    public void setCustomer_last_name(String customer_last_name) {this.customer_last_name = customer_last_name;}
    public void setCustomer_name(String customer_name) {this.customer_name = customer_name;}
    public void setDate(String date) {this.date = date;}
    public void setProduct(String product) {this.product = product;}
    public void setProduct_code(int product_code) {this.product_code = product_code;}
    public void setSale(float sale) {this.sale = sale;}
    public void setQuantity(int quantity) {this.quantity = quantity;}
    public void setValue(float value) {this.value = value;}
    public static void criarNovoArquivoXLS(String nomeArquivo)
    {
        // Verificar se o arquivo já existe
        File arquivo = new File(nomeArquivo);

        if (!arquivo.exists())
        {
            criarNovoArquivoXLS(nomeArquivo);
            System.out.println("Arquivo criado: " + nomeArquivo);
        } else
        {
            System.out.println("Arquivo já existe: " + nomeArquivo);
        }

        WritableWorkbook workbook = null;

        try {
            // Criando os campos
            workbook = Workbook.createWorkbook(new File(nomeArquivo));
            WritableSheet sheet = workbook.createSheet("Sales", 0);

            String[] headers = {
                    "PRODUCT", "PRODUCT CODE", "VALUE", "QUANTITY",
                    "DATE", "SALE", "CUSTOMER NAME", "CUSTOMER LAST NAME",
                    "CUSTOMER CODE", "0", "0"
            };

            for (int i = 0; i < headers.length; i++) {
                Label label = new Label(i, 0, headers[i]);
                sheet.addCell(label);
            }

            // Inserindo os dados

            Sales salesData = new Sales();

            Label productLabel = new Label(0, 1, salesData.getProduct());
            Label productCodeLabel = new Label(1, 1, salesData.getProduct_code());
            Label value = new Label(2, 1, salesData.getValue());
            Label quantity = new Label(3, 1, salesData.getQuantity());
            Label date = new Label(4, 1, salesData.getDate());
            Label sale = new Label(5, 1, salesData.getSale());
            Label customerName = new Label(6, 1, salesData.getCustomer_name());
            Label customerLastName = new Label(7, 1, salesData.getCustomer_last_name());
            Label customerCode = new Label(8, 1, salesData.getCustomer_code());
            Label n1 = new Label(9, 1, "0");
            Label n2 = new Label(10, 1, "0");

            workbook.write();
            workbook.close();

            System.out.println("Dados escritos no arquivo Excel com sucesso!");

        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            if (workbook != null)
            {
                try {
                    workbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
