package com.onlinequiz.sub_category;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.onlinequiz.R;
import com.onlinequiz.model.SubCategory;

public class SubCategoryActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "sub_category_position";
    public static final String EXTRA_TITLE = "sub_category_title";

    public static void startActivity(Context context, String position, String title){
        Intent intent = new Intent(context, SubCategoryActivity.class);
        intent.putExtra(SubCategoryActivity.EXTRA_POSITION,position);
        intent.putExtra(SubCategoryActivity.EXTRA_TITLE,title);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category);
    }
}