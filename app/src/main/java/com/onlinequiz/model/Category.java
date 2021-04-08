package com.onlinequiz.model;

import com.google.gson.annotations.SerializedName;

public class Category {
    @SerializedName("id")
    private String categoryId;

    @SerializedName("name")
    private String categoryName;

    @SerializedName("categories")
    private String category;

    public Category() {
    }

    public Category(String categoryId, String categoryName, String category) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.category = category;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
