package com.onlinequiz.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.google.gson.annotations.SerializedName;
import com.onlinequiz.utils.DescriptionConverter;

import java.util.List;

@Entity(tableName = "sub_categories")
public class Question {
    @PrimaryKey
    @SerializedName("id")
    @NonNull
    private String subCategoryId;

    @SerializedName("name")
    private String subCategoryName;

    @SerializedName("options")
    @TypeConverters({DescriptionConverter.class})
    List<Description> descriptionList;

    public Question() {
    }

    public List<Description> getDescriptionList() {
        return descriptionList;
    }

    public Question(@NonNull String subCategoryId, String subCategoryName, List<Description> descriptionList) {
        this.subCategoryId = subCategoryId;
        this.subCategoryName = subCategoryName;
        this.descriptionList = descriptionList;
    }

    @NonNull
    public String getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(@NonNull String subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }


    public void setDescriptionList(List<Description> descriptionList) {
        this.descriptionList = descriptionList;
    }
}