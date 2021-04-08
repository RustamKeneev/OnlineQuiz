package com.onlinequiz.model;

import com.google.gson.annotations.SerializedName;

public class SubCategory {
    @SerializedName("id")
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
