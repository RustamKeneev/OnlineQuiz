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
    private MaterialCheckBox mStoneInLocationCheckbox;
    private MaterialCheckBox mXRayStoneCheckbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();
    }

    private void initViews() {
        mStartTestButton = findViewById(R.id.start_test_button);
        mStoneInLocationCheckbox = findViewById(R.id.stone_in_location_checkbox);
        mXRayStoneCheckbox  = findViewById(R.id.x_ray_stone_checkbox);

        mStartTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ololo", "onClick: "+ v);
                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                intent.putExtra("checkbox1",mStoneInLocationCheckbox.isChecked());
                intent.putExtra("checkbox2",mXRayStoneCheckbox.isChecked());
                startActivity(intent);
            }
        });
    }
}