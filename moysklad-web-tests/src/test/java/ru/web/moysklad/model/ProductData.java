package ru.web.moysklad.model;

public class ProductData {
    private String name;
    private String sum;
    private String code;
    private String article;
    private String country;
    private String weight;
    private String volume;
    private String vat;
    private String description;
    private String ean13;

    public String getName() {
        return name;
    }

    public String getSum() {
        return sum;
    }

    public String getCode() {
        return code;
    }

    public String getArticle() {
        return article;
    }

    public String getCountry() {
        return country;
    }

    public String getWeight() {
        return weight;
    }

    public String getVolume() {
        return volume;
    }

    public String getVat() {
        return vat;
    }

    public String getDescription() {
        return description;
    }

    public String getEan13() {
        return ean13;
    }

    public ProductData withName(String productName) {
        this.name = productName;
        return this;
    }

    public ProductData withSum(String productSum) {
        this.sum = productSum;
        return this;
    }

    public ProductData withCode(String productCode) {
        this.code = productCode;
        return this;
    }

    public ProductData withArticle(String productArticle) {
        this.article = productArticle;
        return this;
    }

    public ProductData withCountry(String productCountry) {
        this.country = productCountry;
        return this;
    }

    public ProductData withWeight(String productWeight) {
        this.weight = productWeight;
        return this;
    }

    public ProductData withVolume(String productVolume) {
        this.volume = productVolume;
        return this;
    }

    public ProductData withVat(String productVat) {
        this.vat = productVat;
        return this;
    }

    public ProductData withDescription(String productDescription) {
        this.description = productDescription;
        return this;
    }

    public ProductData withEan13(String productEan13) {
        this.ean13 = productEan13;
        return this;
    }
}
