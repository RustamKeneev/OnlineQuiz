package com.onlinequiz.repository;

import com.onlinequiz.model.Category;

import java.util.List;

public interface IRepository {
    void getCategory(CategoryCallback categoryCallback);

    interface CategoryCallback{
        void onSuccess(List<Category> categories);
        void onFailure(Exception e);
    }

    interface CallBack<T>{
        void onSuccess(T t);
        void onFailure(Exception e);
    }
}
