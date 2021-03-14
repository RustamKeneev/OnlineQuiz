package com.onlinequiz.model;

public class Description {
    private String id;
    private String descriptionName;
    private String description;


    public Description() {
    }

    public Description(String id, String descriptionName, String description) {
        this.id = id;
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
