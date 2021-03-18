package com.onlinequiz.question;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.onlinequiz.App;
import com.onlinequiz.model.Question;
import com.onlinequiz.repository.IRepository;

import java.util.List;

public class QuestionViewModel extends ViewModel {
    public MutableLiveData<Question> questionMutableLiveData = new MutableLiveData<>();

    public void getQuestion(){
        App.iRepository.getQuestions(new IRepository.CallBack<List<Question>>() {
            @Override
            public void onSuccess(List<Question> questions) {
                for (Question question:questions){
                    questionMutableLiveData.setValue(question);
                }
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
