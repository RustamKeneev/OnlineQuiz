package com.onlinequiz.repository.local.db;

import androidx.room.Dao;
import androidx.room.Query;

import com.onlinequiz.model.Category;

import java.util.List;

@Dao
public interface MyDao {
    @Query("SELECT * FROM category")
    List<Category> getCategories();
}
