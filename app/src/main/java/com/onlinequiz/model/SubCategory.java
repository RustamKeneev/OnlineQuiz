package com.onlinequiz.model;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "sub_categories")
public class SubCategory {
    @PrimaryKey
    @SerializedName("id")
    @NonNull
    private String subCategoryId;

    @SerializedName("name")
    private String subCategoryName;

    @SerializedName("options")
    private String getSubCategoryOption;

    public SubCategory() {
    }

    public SubCategory(String subCategoryId, String subCategoryName, String getSubCategoryOption) {
        this.subCategoryId = subCategoryId;
        this.subCategoryName = subCategoryName;
        this.getSubCategoryOption = getSubCategoryOption;
    }

    public String getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(String subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getGetSubCategoryOption() {
        return getSubCategoryOption;
    }

    public void setGetSubCategoryOption(String getSubCategoryOption) {
        this.getSubCategoryOption = getSubCategoryOption;
    }
}