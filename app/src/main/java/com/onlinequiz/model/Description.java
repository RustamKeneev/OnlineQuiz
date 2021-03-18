package com.onlinequiz.model;

import com.google.gson.annotations.SerializedName;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class Description {
    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String descriptionName;

    @SerializedName("description")
    private String description;

    public Description() {
    }

    public Description(String descriptionName, String description) {
        this.descriptionName = descriptionName;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescriptionName() {
        return descriptionName;
    }

    public void setDescriptionName(String descriptionName) {
        this.descriptionName = descriptionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
