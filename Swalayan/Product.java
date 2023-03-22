package Swalayan;

public class Product {
    private double price;
    private String nameProduct;

    Product(double price, String nameProduct){
        this.price = price;
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public String getNameProduct() {
        return nameProduct;
    }
}
