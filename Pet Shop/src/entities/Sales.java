package entities;

import jxl.Cell;
import jxl.CellType;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.Number;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Sales
{
    private String product;
    private String product_code;
    private float value;
    private int quantity;
    private String date;
    private float sale;
    private String customer_name;
    private String customer_last_name;
    private int customer_code;

    // Construtores
    public Sales() {}

    public Sales(String product, int product_code, float d, int quantity, String date, float sale, String customer_name,
                 String customer_last_name, int customer_code)
    {
        this.product = product;
        this.product_code = String.valueOf(product_code);
        this.value = d;
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
    public String getProduct_code() { return product_code; }
    public int getProduct_code_int() { return Integer.parseInt(product_code); }
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
    public void setProduct_code(String product_code) { this.product_code = product_code; }
    public void setSale(float sale) { this.sale = sale; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setValue(float value) { this.value = value; }

    public static void createNewFile(String fileName, List<Sales> salesList) {
        WritableWorkbook workbook = null;

        try {
            File file = new File(fileName);
            workbook = Workbook.createWorkbook(file);
            WritableSheet sheet = workbook.createSheet("Sales", 0);

            escreverHeaders(sheet);
            escreverSales(sheet, salesList);

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
    public static void adicionarVenda(String fileName, Sales sale) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                System.out.println("O arquivo " + fileName + " não existe.");
                return;
            }

            Workbook workbook = Workbook.getWorkbook(file);
            WritableWorkbook copy = Workbook.createWorkbook(file, workbook);
            WritableSheet salesSheet = copy.getSheet("Sales");
            WritableSheet productsSheet = copy.getSheet("Products");

            int salesRow = salesSheet.getRows(); // Obtém o número de linhas atual na planilha "Sales"

            // Verifica se há quantidade disponível do produto na planilha "Products"
            int productRow = findProductRow(productsSheet, sale.getProduct_code_int());
            if (productRow == -1 || getQuantityFromProducts(productsSheet, productRow) <= 0 || getQuantityFromProducts(productsSheet, productRow)-sale.quantity<0 ) {
                System.out.println("Venda cancelada devido a quantidade insuficiente do produto.");
                copy.write();
                copy.close();
                return;
            }

            // Atualiza a quantidade do produto na planilha "Products"
            decrementProductQuantity(productsSheet, productRow,sale.quantity);

            // Atualiza o valor da coluna "Sales" na planilha "Products" para o número de vendas efetuadas
            updateProductSales(productsSheet, productRow, sale.getQuantity());

            Label productLabel = new Label(0, salesRow, sale.getProduct());
            Label productCodeLabel = new Label(1, salesRow, String.valueOf(sale.getProduct_code()));
            Label valueLabel = new Label(2, salesRow, String.valueOf(sale.getValue()));
            Label quantityLabel = new Label(3, salesRow, String.valueOf(sale.getQuantity()));
            Label dateLabel = new Label(4, salesRow, sale.getDate());
            Label saleLabel = new Label(5, salesRow, String.valueOf(sale.getSale()));
            Label customerNameLabel = new Label(6, salesRow, sale.getCustomer_name());
            Label customerLastNameLabel = new Label(7, salesRow, sale.getCustomer_last_name());
            Label customerCodeLabel = new Label(8, salesRow, String.valueOf(sale.getCustomer_code()));

            salesSheet.addCell(productLabel);
            salesSheet.addCell(productCodeLabel);
            salesSheet.addCell(valueLabel);
            salesSheet.addCell(quantityLabel);
            salesSheet.addCell(dateLabel);
            salesSheet.addCell(saleLabel);
            salesSheet.addCell(customerNameLabel);
            salesSheet.addCell(customerLastNameLabel);
            salesSheet.addCell(customerCodeLabel);

            copy.write();
            copy.close();
            System.out.println("Venda adicionada com sucesso!");
        } catch (IOException | BiffException | WriteException e) {
            e.printStackTrace();
        }
    }
    public static void updateProductSales(WritableSheet productsSheet, int productRow, int quantity) throws WriteException {
        int currentSales = getSalesFromProducts(productsSheet, productRow);
        WritableCell salesCell = productsSheet.getWritableCell(3, productRow); // Assuming sales is in the fourth column (index 3)
        NumberFormat format = new NumberFormat("#");
        Number number = new Number(3, productRow, currentSales + quantity);
        productsSheet.addCell(number);
    }

    // Método para obter o valor da coluna "Sales" na planilha "Products"
    public static int getSalesFromProducts(WritableSheet productsSheet, int productRow) {
        Cell salesCell = productsSheet.getCell(3, productRow); // Assuming sales is in the fourth column (index 3)
        return Integer.parseInt(salesCell.getContents());
    }
    public static int findProductRow(WritableSheet productsSheet, int productCode) {
        int rows = productsSheet.getRows();
        for (int row = 1; row < rows; row++) {
            Cell cell = productsSheet.getCell(1, row); // Assuming product code is in the second column (index 1)
            if (cell.getContents().equals(String.valueOf(productCode))) {
                return row;
            }
        }
        return -1; // Product not found
    }
    public static int getQuantityFromProducts(WritableSheet productsSheet, int productRow) {
        Cell quantityCell = productsSheet.getCell(4, productRow); // Assuming quantity is in the fifth column (index 4)
        return Integer.parseInt(quantityCell.getContents());
    }
    public static void decrementProductQuantity(WritableSheet productsSheet, int productRow, int Sales) throws WriteException {
        int currentQuantity = getQuantityFromProducts(productsSheet, productRow);
        if (currentQuantity > 0) {
            WritableCell quantityCell = productsSheet.getWritableCell(4, productRow); // Assuming quantity is in the fifth column (index 4)
            NumberFormat format = new NumberFormat("#");
            Number number = new Number(4, productRow, currentQuantity - Sales);
            productsSheet.addCell(number);
        } else {
            System.out.println("Quantidade insuficiente do produto para realizar a venda.");
        }
    }

    private static void escreverHeaders(WritableSheet sheet) throws WriteException {
        String[] headers = {
                "PRODUCT", "PRODUCT CODE", "VALUE", "QUANTITY",
                "DATE", "SALE", "CUSTOMER NAME", "CUSTOMER LAST NAME",
                "CUSTOMER CODE", "0"
        };

        for (int i = 0; i < headers.length; i++) {
            Label label = new Label(i, 0, headers[i]);
            sheet.addCell(label);
        }
    }

    private static void escreverSales(WritableSheet sheet, List<Sales> salesList) throws WriteException {
        int row = 1;
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
    }

    public static void modifyData(WritableCell cell, String novastring) throws Exception
    {
        if (cell.getType() == CellType.LABEL)
        {
            Label l = (Label) cell;
            l.setString(novastring);
        } else if (cell.getType() == CellType.NUMBER)
        {
            Label n = (Label) cell;
            n.setString(novastring);
        } else
        {
            System.out.println("Other data... ");
        }
    }

    public static void excluirProduto(String fileName, String productCode) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                System.out.println("O arquivo " + fileName + " não existe.");
                return;
            }
            Workbook workbook = Workbook.getWorkbook(file);
            WritableWorkbook copy = Workbook.createWorkbook(file, workbook);
            WritableSheet sheet = copy.getSheet("Sales");

            int totalLinhas = sheet.getRows();
            int linhaExclusao = -1;

            // Procurar o produto na planilha pelo código
            for (int i = 1; i < totalLinhas; i++) {
                Cell cell = sheet.getCell(1, i);
                String code = cell.getContents();
                if (code.equals(productCode)) {
                    linhaExclusao = i;
                    break;
                }
            }

            if (linhaExclusao != -1) {
                sheet.removeRow(linhaExclusao);
                copy.write();
                copy.close();
                System.out.println("Produto excluído com sucesso!");
            } else {
                System.out.println("Produto não encontrado na planilha.");
            }
        } catch (IOException | BiffException | WriteException e) {
            e.printStackTrace();
        }
    }
    
    private static void escreverSalesReportHeaders(WritableSheet sheet) throws WriteException {
        String[] headers = {
                "PRODUCT", "QUANTITY SOLD", "TOTAL REVENUE"
        };

        for (int i = 0; i < headers.length; i++) {
            Label label = new Label(i, 0, headers[i]);
            sheet.addCell(label);
        }
    }
    private static void escreverSalesReport(WritableSheet sheet, List<Sales> salesList) throws WriteException {
        int row = 1;
        for (Sales salesData : salesList) {
            Label productLabel = new Label(0, row, salesData.getProduct());
            Label quantitySoldLabel = new Label(1, row, String.valueOf(salesData.getQuantity()));
            Label totalRevenueLabel = new Label(2, row, String.valueOf(salesData.getValue() * salesData.getQuantity()));

            sheet.addCell(productLabel);
            sheet.addCell(quantitySoldLabel);
            sheet.addCell(totalRevenueLabel);

            row++;
        }
    }

}
