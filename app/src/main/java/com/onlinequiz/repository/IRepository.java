package com.onlinequiz.repository;

import com.onlinequiz.model.Category;
import com.onlinequiz.model.OptionList;
import com.onlinequiz.model.Question;

import java.util.List;

public interface IRepository {
    void getCategory(CategoryCallback categoryCallback);

    void getQuestions(CallBack<List<Question>> callBack);

    void getOptionList(CallBack<List<OptionList>> callBack);
    void getOptionListById(List<Integer> id,CallBack<List<OptionList>> callBack);

    interface CategoryCallback{
        void onSuccess(List<Category> categories);
        void onFailure(Exception e);
    }

    interface CallBack<T>{
        void onSuccess(T t);
        void onFailure(Exception e);
    }
}
