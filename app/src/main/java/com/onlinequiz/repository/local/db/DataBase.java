package com.onlinequiz.repository.local.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.onlinequiz.model.Category;
import com.onlinequiz.model.SubCategory;


@Database(entities = {Category.class, SubCategory.class},version = 1,exportSchema = false)
public abstract class DataBase extends RoomDatabase {
    public abstract MyDao myDao();
}
