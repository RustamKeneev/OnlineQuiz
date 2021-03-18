package com.onlinequiz.question;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.onlinequiz.R;
import com.onlinequiz.model.Description;
import com.onlinequiz.model.Question;
import com.onlinequiz.question.question_adapter.QuestionAdapter;
import com.onlinequiz.test_sucategory.Item;
import com.onlinequiz.test_sucategory.ItemAdapter;
import com.onlinequiz.test_sucategory.SubItem;
import com.onlinequiz.test_sucategory.TestSubCategoryActivity;

import java.util.ArrayList;
import java.util.List;

public class QuestionActivity extends AppCompatActivity {

    private RecyclerView rvItem;
    QuestionViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        initViews();
        initModels();
    }

    private void initModels() {
        viewModel = ViewModelProviders.of(this).get(QuestionViewModel.class);
        viewModel.getQuestion();
        viewModel.questionMutableLiveData.observe(this, new Observer<Question>() {
            @Override
            public void onChanged(Question question) {
                Log.d("TAG", "onChanged: " + question.getSubCategoryName());
            }
        });
    }

    private void initViews() {
        rvItem = findViewById(R.id.rv_item);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(QuestionActivity.this);
//        QuestionAdapter questionAdapter = new QuestionAdapter(buildItemList());
//        rvItem.setAdapter(questionAdapter);
//        rvItem.setLayoutManager(layoutManager);
    }

//    private List<Question> buildItemList() {
//        List<Question> itemList = new ArrayList<>();
//        for (int i = 1; i <= 10; i++) {
//            Question item = new Question("Id:" + i, "Name:" + i, buildSubItemList());
//            itemList.add(item);
//        }
//        return itemList;
//    }
//
//    private List<Description> buildSubItemList() {
//        List<Description> subItemList = new ArrayList<>();
//        for (int i = 1; i <= 5; i++) {
//            Description subItem = new Description("Кнопка для ответа " + i, "Подробнее " + i);
//            subItemList.add(subItem);
//        }
//        return subItemList;
//    }
}