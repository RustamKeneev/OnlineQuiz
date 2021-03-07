package com.onlinequiz.repository.remote;

import com.onlinequiz.repository.IRepository;

public interface IApiClient {
    void getCategories(IRepository.CategoryCallback categoryCallback);
}
