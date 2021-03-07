package com.onlinequiz.repository.local;

import com.onlinequiz.repository.local.db.MyDao;

public class LocalStorage implements ILocalStorage{
    private MyDao myDao;
    public LocalStorage(MyDao dao){
        myDao = dao;
    }
}
