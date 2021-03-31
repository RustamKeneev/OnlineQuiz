package com.onlinequiz.repository;

import com.onlinequiz.model.OptionList;
import com.onlinequiz.model.Question;
import com.onlinequiz.repository.local.ILocalStorage;
import com.onlinequiz.repository.remote.IApiClient;

import java.util.List;

public class Repository implements IRepository{
    private IApiClient apiClient;
    private ILocalStorage localStorage;


    public Repository(IApiClient apiClient, ILocalStorage localStorage) {
        this.apiClient = apiClient;
        this.localStorage = localStorage;
    }

    @Override
    public void getCategory(CategoryCallback categoryCallback) {
        apiClient.getCategories(categoryCallback);
    }

    @Override
    public void getQuestions( CallBack<List<Question>> callBack) {
        apiClient.getQuestions(callBack);
    }

    @Override
    public void getOptionList(CallBack<List<OptionList>> callBack) {
        apiClient.getOptionList(callBack);
    }


}
