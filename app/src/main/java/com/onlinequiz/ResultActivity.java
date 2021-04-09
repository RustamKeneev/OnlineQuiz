package com.onlinequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.onlinequiz.fragments.XRayStoneFragmentResult;
import com.onlinequiz.model.OptionList;

public class ResultActivity extends AppCompatActivity {

    String single;

    private TextView result_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        single = getIntent().getStringExtra("option_post_answer");
        initViews();
    }



    private void initViews() {
        result_text = findViewById(R.id.result_text);
        result_text.setText(single);
    }
}