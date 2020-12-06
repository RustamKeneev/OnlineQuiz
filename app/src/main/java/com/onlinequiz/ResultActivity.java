package com.onlinequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.onlinequiz.fragments.XRayStoneFragmentResult;

public class ResultActivity extends AppCompatActivity {

    String single;
    String details;
    String clinic;

    private TextView result_text;
    private TextView details_text;
    private TextView by_clinic_text_result;

    private Boolean mByClinicCheckbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        single = getIntent().getStringExtra("result");
        details = getIntent().getStringExtra("details");
        mByClinicCheckbox = getIntent().getExtras().getBoolean("clinic");
        clinic = getIntent().getStringExtra("clinic");

        initFragments();
        initViews();
    }

    private void initFragments() {
            XRayStoneFragmentResult xRayStoneFragmentResult = new XRayStoneFragmentResult();
            xRayStoneFragmentResult.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(
                    R.id.by_clinic_text_result_fragment, xRayStoneFragmentResult).commit();
    }

    private void initViews() {
        result_text = findViewById(R.id.result_text);
        details_text = findViewById(R.id.details_text);
//        by_clinic_text_result = findViewById(R.id.by_clinic_text_result);
        result_text.setText(single);
        details_text.setText(details);
//        by_clinic_text_result.setText(clinic);
    }
}