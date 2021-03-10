package com.onlinequiz.category;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.onlinequiz.R;
import com.onlinequiz.category.recycler.CategoryAdapter;
import com.onlinequiz.category.recycler.CategoryViewHolder;
import com.onlinequiz.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity implements CategoryViewHolder.IOnClickListener {

    private CategoryViewModel mViewModel;
    private RecyclerView mRecyclerView;
    private CategoryAdapter mAdapter;
    private List<Category> mCategories;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        initViewModels();
        initViews();
    }

    private void initViewModels() {
        mViewModel = ViewModelProviders.of(this).get(CategoryViewModel.class);
        mViewModel.getCategory();
        mViewModel.categoryLiveData.observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {
                mAdapter.setData(categories);
                mCategories = new ArrayList<>();
                mCategories.addAll(categories);
            }
        });
    }

    private void initViews() {
        mRecyclerView = findViewById(R.id.category_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new CategoryAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onClick(String categoryId, String categoryTitle) {

    }
}