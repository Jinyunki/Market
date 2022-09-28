package com.example.market.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Product {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "productName")
    public String productName;

    @ColumnInfo(name = "productCategory")
    public String productCategory;

    @ColumnInfo(name = "tag")
    public String tag;

    @ColumnInfo(name = "price")
    public int price;

    @ColumnInfo(name = "productDescription")
    public String productDescription;

    public Product() {}

    public Product(String productName, String productCategory, String tag, int price, String productDescription) {
        this.productName = productName;
        this.productCategory = productCategory;
        this.tag = tag;
        this.price = price;
        this.productDescription = productDescription;
    }

    public Product(int id, String productName, String productCategory, String tag, int price, String productDescription) {
        this.id = id;
        this.productName = productName;
        this.productCategory = productCategory;
        this.tag = tag;
        this.price = price;
        this.productDescription = productDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
