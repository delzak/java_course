package ru.web.moysklad.model;

public class ProductData {
    private final String productName;
    private final String productSum;

    public ProductData(String productName, String productSumm) {
        this.productName = productName;
        this.productSum = productSumm;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductSum() {
        return productSum;
    }
}
