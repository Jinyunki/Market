package com.example.market.data;

public class DataProduct {
    String productName;
    String productCategory;
    String tag;
    int price;
    String productDescription;

    public DataProduct() {
    }

    public DataProduct(String productName, String productCategory, String tag, int price, String productDescription) {
        this.productName = productName;
        this.productCategory = productCategory;
        this.tag = tag;
        this.price = price;
        this.productDescription = productDescription;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}
