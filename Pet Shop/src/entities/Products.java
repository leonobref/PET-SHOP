package entities;

public class Products {
    private String name;
    private String code;
    private String category;
    private int sales;
    private int quantity;
    private double costprice;
    private double saleprice;
    private boolean active;

    public Products(){}

    public Products(String name, String code, String category, int sales, int quantity, double costprice, double saleprice, boolean active) {
        this.name = name;
        this.code = code;
        this.category = category;
        this.sales = sales;
        this.quantity = quantity;
        this.costprice = costprice;
        this.saleprice = saleprice;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCostprice() {
        return costprice;
    }

    public void setCostprice(double costprice) {
        this.costprice = costprice;
    }

    public double getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(double saleprice) {
        this.saleprice = saleprice;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Products{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", category='" + category + '\'' +
                ", sales=" + sales +
                ", quantity=" + quantity +
                ", costprice=" + costprice +
                ", saleprice=" + saleprice +
                ", active=" + active +
                '}';
    }
}
