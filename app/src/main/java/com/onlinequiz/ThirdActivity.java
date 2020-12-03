package com.onlinequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.onlinequiz.fragments.ByEtiologyFragment;
import com.onlinequiz.fragments.StoneLocationFragment;
import com.onlinequiz.fragments.XRayStoneFragment;

public class ThirdActivity extends AppCompatActivity {


    Boolean mXRayStoneCheckbox;
    Boolean mStoneByEtiologyCheckbox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        mXRayStoneCheckbox = getIntent().getExtras().getBoolean("mXRayStoneCheckbox");
        mStoneByEtiologyCheckbox = getIntent().getExtras().getBoolean("mStoneByEtiologyCheckbox");

            StoneLocationFragment stoneLocationFragment = new StoneLocationFragment();
            stoneLocationFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(
                    R.id.location_fragment_id,stoneLocationFragment).commit();

        if (mXRayStoneCheckbox){
            XRayStoneFragment xRayStoneFragment = new XRayStoneFragment();
            xRayStoneFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(
                    R.id.x_ray_fragment_id,xRayStoneFragment).commit();
        }else {

        }
        if (mStoneByEtiologyCheckbox){
            ByEtiologyFragment byEtiologyFragment = new ByEtiologyFragment();
            byEtiologyFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(
                    R.id.by_etiology_fragment_id,byEtiologyFragment).commit();
        }
    }
}