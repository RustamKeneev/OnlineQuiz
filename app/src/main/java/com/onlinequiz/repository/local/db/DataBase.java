package com.onlinequiz.repository.local.db;

import androidx.room.RoomDatabase;

public abstract class DataBase extends RoomDatabase {
    public abstract MyDao myDao();
}
