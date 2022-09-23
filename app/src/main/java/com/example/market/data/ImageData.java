package com.example.market.data;

public class ImageData {
    String imageUrl;

    public ImageData() {}

    public ImageData(String url) {
        this.imageUrl = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
