package com.onlinequiz.question;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import com.onlinequiz.R;
import com.onlinequiz.category.CategoryViewModel;
import com.onlinequiz.model.Category;
import com.onlinequiz.question.question_adapter.QuestionAdapter;
import java.util.List;

public class QuestionActivity extends AppCompatActivity {

    private RecyclerView rvItem;
    CategoryViewModel viewModel;
    QuestionViewModel questionViewModel;
    LinearLayoutManager layoutManager;
    QuestionAdapter questionAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        rvItem = findViewById(R.id.rv_questions);
        layoutManager = new LinearLayoutManager(QuestionActivity.this);
        initViews();
        initModels();
    }

    private void initModels() {
        viewModel = ViewModelProviders.of(this).get(CategoryViewModel.class);
        questionViewModel = ViewModelProviders.of(this).get(QuestionViewModel.class);
        viewModel.getCategory();
        viewModel.categoryLiveData.observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {
                Log.d("TAG", "onChanged: Question " + categories.size());
            }
        });
        questionViewModel.getCategory();
        questionViewModel.categoryLiveData.observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {
                questionAdapter = new QuestionAdapter(categories.get(0).getCategory());
                rvItem.setLayoutManager(layoutManager);
                rvItem.setAdapter(questionAdapter);
            }
        });
    }

    private void initViews() {
    }
}