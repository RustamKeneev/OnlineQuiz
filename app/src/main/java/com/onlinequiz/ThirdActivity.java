package com.onlinequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {


    Boolean check1;
    Boolean check2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        check1 = getIntent().getExtras().getBoolean("checkbox1");
        check2 = getIntent().getExtras().getBoolean("checkbox2");

        if (check1){
            StoneLocationFragment stoneLocationFragment = new StoneLocationFragment();
            stoneLocationFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(
                    R.id.first_fragment_id,stoneLocationFragment).commit();
        }else {
        }
        if (check2){
            Toast.makeText(this,"Pressed2",Toast.LENGTH_LONG).show();
            XRayStoneFragment xRayStoneFragment = new XRayStoneFragment();
            xRayStoneFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(
                    R.id.second_fragment_id,xRayStoneFragment).commit();
        }else {

        }
    }
}