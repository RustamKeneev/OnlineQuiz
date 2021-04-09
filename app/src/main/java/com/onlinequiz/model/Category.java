package com.onlinequiz.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.google.gson.annotations.SerializedName;
import com.onlinequiz.utils.QuestionConverter;

import java.util.List;

@Entity(tableName = "category")
public class Category {

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    private int categoryId;
    @SerializedName("name")
    private String categoryName;

    @SerializedName("categories")
    @TypeConverters({QuestionConverter.class})
    public List<Question> categories;

    public Category() {
    }

    public Category(int categoryId, String categoryName, List<Question> categories) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categories = categories;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Question> getCategory() {
        return categories;
    }

    public void setCategory(List<Question> categories) {
        this.categories = categories;
    }
}