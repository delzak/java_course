package ru.web.moysklad.model;

public class ProductData {
    private String productName;
    private String productSum;

    public String getProductName() {
        return productName;
    }

    public String getProductSum() {
        return productSum;
    }

    public ProductData withProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public ProductData withProductSum(String productSum) {
        this.productSum = productSum;
        return this;
    }
}
