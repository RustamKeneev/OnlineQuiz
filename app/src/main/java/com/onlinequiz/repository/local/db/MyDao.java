package com.onlinequiz.repository.local.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.onlinequiz.model.Category;
import com.onlinequiz.model.OptionList;

import java.util.List;

@Dao
public interface MyDao {
    @Query("SELECT * FROM category")
    List<Category> getCategories();

    @Query("SELECT * FROM option_list WHERE id == :id")
    OptionList getOptionById(int id);

    @Insert
    public void saveOptionsList(List<OptionList> optionLists);
}
