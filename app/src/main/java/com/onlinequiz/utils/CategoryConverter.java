package com.onlinequiz.utils;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.onlinequiz.model.Category;
import com.onlinequiz.model.Question;

import java.lang.reflect.Type;
import java.util.List;

import kotlin.jvm.JvmStatic;

public class CategoryConverter {
    @JvmStatic
    @TypeConverter
    public static List<Category> fromString(String value) {
        Type listType = new TypeToken<List<Category>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }
    @JvmStatic
    @TypeConverter
    public static String fromCategory(List<Category> category) {
        Gson gson = new Gson();
        String json = gson.toJson(category);
        return json;
    }
}
