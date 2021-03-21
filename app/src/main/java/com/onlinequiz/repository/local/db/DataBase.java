package com.onlinequiz.repository.local.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.onlinequiz.model.Category;
import com.onlinequiz.model.Question;
import com.onlinequiz.utils.CategoryConverter;
import com.onlinequiz.utils.DescriptionConverter;
import com.onlinequiz.utils.QuestionConverter;


@Database(entities = {Category.class, Question.class},version = 2,exportSchema = false)
@TypeConverters({CategoryConverter.class, QuestionConverter.class})
public abstract class DataBase extends RoomDatabase {
    public abstract MyDao myDao();
}
