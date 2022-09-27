package com.example.market.data;

public class CategoryData {
    String[] categoryName;
    Integer[] categoryIcon;

    public CategoryData() {}

    public CategoryData(String[] categoryName, Integer[] categoryIcon) {
        this.categoryName = categoryName;
        this.categoryIcon = categoryIcon;
    }

    public String[] getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String[] categoryName) {
        this.categoryName = categoryName;
    }

    public Integer[] getCategoryIcon() {
        return categoryIcon;
    }

    public void setCategoryIcon(Integer[] categoryIcon) {
        this.categoryIcon = categoryIcon;
    }
}
