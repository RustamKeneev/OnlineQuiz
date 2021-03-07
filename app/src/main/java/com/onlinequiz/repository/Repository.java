package com.onlinequiz.repository;

import com.onlinequiz.repository.local.ILocalStorage;
import com.onlinequiz.repository.remote.IApiClient;

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
}
