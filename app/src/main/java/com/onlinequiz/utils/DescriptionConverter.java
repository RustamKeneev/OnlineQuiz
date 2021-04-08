package com.onlinequiz.utils;

import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.onlinequiz.model.Description;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kotlin.jvm.JvmStatic;

public class DescriptionConverter {
    @JvmStatic
    @TypeConverter
    public static List<Description> fromString(String value) {
        Type listType = new TypeToken<List<Description>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }
    @JvmStatic
    @TypeConverter
    public static String fromListDescription(List<Description> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }
}
