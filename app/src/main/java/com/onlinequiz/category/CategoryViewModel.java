package com.onlinequiz.category;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.onlinequiz.App;
import com.onlinequiz.model.Category;
import com.onlinequiz.repository.IRepository;

import java.util.List;

public class CategoryViewModel extends ViewModel {
    public MutableLiveData<List<Category>> categoryLiveData = new MutableLiveData<>();

    public void getCategory(){
        Log.d("here " , "here");
        App.iRepository.getCategory(new IRepository.CategoryCallback() {
            @Override
            public void onSuccess(List<Category> categories) {
                categoryLiveData.setValue(categories);
                Log.d("TAG", "onSuccess: "+ categories.size());
            }

            @Override
            public void onFailure(Exception e) {
                Log.d("here ", e.getMessage());
            }
        });
    }
}
