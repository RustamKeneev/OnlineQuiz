package com.onlinequiz.question;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.onlinequiz.App;
import com.onlinequiz.model.Category;
import com.onlinequiz.model.OptionList;
import com.onlinequiz.model.Question;
import com.onlinequiz.repository.IRepository;
import com.onlinequiz.repository.remote.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;

public class QuestionViewModel extends ViewModel {
    public MutableLiveData<Question> questionMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<List<Category>> categoryLiveData = new MutableLiveData<>();

    public MutableLiveData<List<OptionList>> optionlistData = new MutableLiveData<>();

    public List<Question> list = new ArrayList<>();
    public List<OptionList> optionLists = new ArrayList<>();

    public void getCategory(){
        App.iRepository.getCategory(new IRepository.CategoryCallback() {
            @Override
            public void onSuccess(List<Category> categories) {
                categoryLiveData.setValue(categories);
                Log.d("TAG", "onSuccess: "+ categories.size());
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }

    public void getOptionList(){
        App.iRepository.getOptionList(new IRepository.CallBack<List<OptionList>>() {
            @Override
            public void onSuccess(List<OptionList> optionLists) {
                optionlistData.setValue(optionLists);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }

//    public void getQuestions(){
//       App.iRepository.getQuestions(new IRepository.CallBack<List<Question>>() {
//           @Override
//           public void onSuccess(List<Question> questions) {
//               list.addAll(questions);
//               Log.d("ololo111", questions.toString());
//           }
//
//           @Override
//           public void onFailure(Exception e) {
//
//           }
//       });
//        ApiClient client = new ApiClient();
//        client.getQuestions(new IRepository.CallBack<List<Question>>() {
//            @Override
//            public void onSuccess(List<Question> questions) {
//                for (int i = 0; i < questions.size(); i++) {
//                    Log.d("ololo123", questions.get(i).getSubCategoryName());
//                }
//            }
//
//            @Override
//            public void onFailure(Exception e) {
//
//            }
//        });

    }

//    public void getQuestion(){
//        App.iRepository.getQuestions(new IRepository.CallBack<List<Question>>() {
//            @Override
//            public void onSuccess(List<Question> questions) {
//                for (Question question:questions){
//                    questionMutableLiveData.setValue(question);
//                }
//            }
//
//            @Override
//            public void onFailure(Exception e) {
//
//            }
//        });
//    }
//}
