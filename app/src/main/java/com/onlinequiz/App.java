package com.onlinequiz;

import android.app.Application;

import androidx.room.Room;

import com.onlinequiz.repository.IRepository;
import com.onlinequiz.repository.Repository;
import com.onlinequiz.repository.local.ILocalStorage;
import com.onlinequiz.repository.local.LocalStorage;
import com.onlinequiz.repository.local.db.DataBase;
import com.onlinequiz.repository.remote.ApiClient;
import com.onlinequiz.repository.remote.IApiClient;
import com.onlinequiz.utils.ISharedStorage;
import com.onlinequiz.utils.SharedStorage;

public class App extends Application {
    public static ISharedStorage iSharedStorage;
    public static AppPreferences appPreferences;
    public static IRepository iRepository;
    private static IApiClient apiClient;
    private static ILocalStorage iLocalStorage;
    private static DataBase dataBase;

    @Override
    public void onCreate() {
        super.onCreate();

        iSharedStorage = new SharedStorage(this,"pref");
        appPreferences = new AppPreferences(iSharedStorage);
        apiClient = new ApiClient();
        dataBase = Room
                .databaseBuilder(this,DataBase.class,"app_database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        iLocalStorage = new LocalStorage(dataBase.myDao());
        iRepository = new Repository(apiClient,iLocalStorage);
    }
}
