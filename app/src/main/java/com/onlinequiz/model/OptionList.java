package com.onlinequiz.model;
import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import com.google.gson.annotations.SerializedName;
import com.onlinequiz.utils.DescriptionConverter;
import com.onlinequiz.utils.OptionListConverter;
import java.util.List;

@Entity(tableName = "option_list")
public class OptionList {
    @PrimaryKey
    @NonNull
    @SerializedName("id")
    private int id;

    @SerializedName("options_post_answers")
    private String optionsPostAnswers;

    @TypeConverters({OptionListConverter.class})
    @SerializedName("options")
    List<OptionList> descriptionList;

    public OptionList(int id, String optionsPostAnswers, List<OptionList> descriptionList) {
        this.id = id;
        this.optionsPostAnswers = optionsPostAnswers;
        this.descriptionList = descriptionList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOptionsPostAnswers() {
        return optionsPostAnswers;
    }

    public void setOptionsPostAnswers(String optionsPostAnswers) {
        this.optionsPostAnswers = optionsPostAnswers;
    }

    public List<OptionList> getDescriptionList() {
        return descriptionList;
    }

    public void setDescriptionList(List<OptionList> descriptionList) {
        this.descriptionList = descriptionList;
    }
}
