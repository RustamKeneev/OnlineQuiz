package com.onlinequiz.repository.remote;

import com.onlinequiz.model.OptionList;
import com.onlinequiz.model.Question;
import com.onlinequiz.repository.IRepository;

import java.util.List;

public interface IApiClient {
    void getCategories(IRepository.CategoryCallback categoryCallback);

    void getQuestions(IRepository.CallBack<List<Question>> callBack);

    void  getOptionList(IRepository.CallBack<List<OptionList>> callBack);



}
