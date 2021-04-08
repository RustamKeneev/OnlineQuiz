package com.onlinequiz.question;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.onlinequiz.R;
import com.onlinequiz.category.CategoryViewModel;
import com.onlinequiz.model.Category;
import com.onlinequiz.model.Description;
import com.onlinequiz.model.OptionList;
import com.onlinequiz.question.question_adapter.DescriptionAdapter;
import com.onlinequiz.question.question_adapter.OnCheckedListener;
import com.onlinequiz.question.question_adapter.QuestionAdapter;

import java.util.ArrayList;
import java.util.List;

public class QuestionActivity extends AppCompatActivity implements OnCheckedListener {

    private RecyclerView rvItem;
    CategoryViewModel viewModel;
    QuestionViewModel questionViewModel;
    LinearLayoutManager layoutManager;
    QuestionAdapter questionAdapter;
    private Button resultButton;
    private List<Integer> checkList;
    private static final String IDS = "ids";




    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        rvItem = findViewById(R.id.rv_questions);
        layoutManager = new LinearLayoutManager(QuestionActivity.this);
        initViews();
        initModels();
        checkList = new ArrayList<>();
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
                questionAdapter = new QuestionAdapter(categories.get(0).getCategory(), questionViewModel, QuestionActivity.this,QuestionActivity.this);
                rvItem.setLayoutManager(layoutManager);
                rvItem.setAdapter(questionAdapter);
            }
        });

        questionViewModel.getOptionList();
        questionViewModel.optionlistData.observe(this, new Observer<List<OptionList>>() {
            @Override
            public void onChanged(List<OptionList> optionLists) {
                Log.d("Rustam", "onChanged: " + optionLists.size());
            }
        });

//        questionViewModel.getOptionListById(IDS);

    }

    private void initViews() {
        resultButton = findViewById(R.id.result_button);

        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                questionViewModel.getOptionListById(IDS);
                 questionViewModel.getOptionListById(checkList);
            }
        });
    }

    @Override
    public void checked(Boolean isChecked, Description description) {
        if (isChecked) {
            checkList.add(Integer.parseInt(description.getId()));
            Log.e("TAG", "checked: " + checkList.size() );
        }else {
            checkList.remove(Integer.parseInt(description.getId()));
        }
    }
}