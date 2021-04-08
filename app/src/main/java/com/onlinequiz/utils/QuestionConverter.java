package com.onlinequiz.utils;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.onlinequiz.model.Description;
import com.onlinequiz.model.Question;

import java.lang.reflect.Type;
import java.util.List;

import kotlin.jvm.JvmStatic;

public class QuestionConverter {
    @JvmStatic
    @TypeConverter
    public static List<Question> fromString(String value) {
        Type listType = new TypeToken<List<Question>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }
    @JvmStatic
    @TypeConverter
    public static String fromListQuestion(List<Question> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }
}
