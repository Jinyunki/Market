package com.example.market.data;

public class RecommendItemData {
    String brandName;
    String imageUri;
    String brandCount;

    public RecommendItemData() {}

    public RecommendItemData(String brandName, String imageUri, String brandCount) {
        this.brandName = brandName;
        this.imageUri = imageUri;
        this.brandCount = brandCount;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public String getBrandCount() {
        return brandCount;
    }

    public void setBrandCount(String brandCount) {
        this.brandCount = brandCount;
    }
}
