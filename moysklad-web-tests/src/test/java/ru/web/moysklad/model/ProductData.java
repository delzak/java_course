package ru.web.moysklad.model;

public class ProductData {
    private String productName;
    private String productSum;

    public ProductData(String productName, String productSumm) {
        this.productName = productName;
        this.productSum = productSumm;
    }

    public ProductData(String productSum) {
        this.productSum = productSum;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductSum() {
        return productSum;
    }
}
