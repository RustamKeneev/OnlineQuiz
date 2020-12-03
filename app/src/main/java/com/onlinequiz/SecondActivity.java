package com.onlinequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

import com.google.android.material.checkbox.MaterialCheckBox;

public class SecondActivity extends AppCompatActivity {

    private Button mStartTestButton;
    private MaterialCheckBox mXRayStoneCheckbox;
    private MaterialCheckBox mStoneByEtiologyCheckbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();
    }

    private void initViews() {
        mStartTestButton = findViewById(R.id.start_test_button);
        mXRayStoneCheckbox = findViewById(R.id.x_ray_stone_checkbox);
        mStoneByEtiologyCheckbox  = findViewById(R.id.by_etiology_stone_checkbox);

        mStartTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                intent.putExtra("mXRayStoneCheckbox",mXRayStoneCheckbox.isChecked());
                intent.putExtra("mStoneByEtiologyCheckbox",mStoneByEtiologyCheckbox.isChecked());
                startActivity(intent);
            }
        });
    }
}