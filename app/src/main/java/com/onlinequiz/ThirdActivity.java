package com.onlinequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.onlinequiz.fragments.ByEtiologyFragment;
import com.onlinequiz.fragments.StoneLocationFragment;
import com.onlinequiz.fragments.XRayStoneFragment;

public class ThirdActivity extends AppCompatActivity {

    private Button mStoneResultButton;

    private EditText mUpperCalyxRightEdit;
    private EditText mMiddleCalyxRightEdit;
    private EditText mLowerCalyxRightEdit;
    private EditText mPelvisRightEdit;
    private EditText mUpperUreterRightEdit;
    private EditText mMiddleUreterRightEdit;
    private EditText mLowerPartOfTheUreterRightEdit;

    String result = "";
    String details = "";
    int single = 0;

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

        initViews();


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

    public void setDataTestFragment(int editOne){

    }

    private void initViews() {
        mStoneResultButton = findViewById(R.id.stone_result_button);
        mStoneResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = "";
                String details = "";
                int single = 0;
                mUpperCalyxRightEdit = findViewById(R.id.upper_calyx_right_edit);
                mMiddleCalyxRightEdit = findViewById(R.id.middle_calyx_right_edit);
                mLowerCalyxRightEdit = findViewById(R.id.lower_calyx_right_edit);
                mPelvisRightEdit = findViewById(R.id.pelvis_right_edit);
                mUpperUreterRightEdit = findViewById(R.id.upper_ureter_right_edit);
                mMiddleUreterRightEdit = findViewById(R.id.middle_ureter_right_edit);
                mLowerPartOfTheUreterRightEdit = findViewById(R.id.lower_part_of_the_ureter_right_edit);


                int mUpperCalyxRight = Integer.parseInt(mUpperCalyxRightEdit.getText().toString());
                if (mUpperCalyxRight>0){
                    details ="Камень верхней чашечки справа с размером " + mUpperCalyxRight + " мм";
                    single++;
                    Log.d("ololo", "onClick: " + details);
                    Toast.makeText(ThirdActivity.this,""+details, Toast.LENGTH_LONG).show();
                }
//                int mMiddleCalyxRight = Integer.parseInt(mMiddleCalyxRightEdit.getText().toString());
//                if (mMiddleCalyxRight>0){
//                    details ="Камень средней чашечки справа с размером " + mMiddleCalyxRight + " мм";
//                    single++;
//                    Log.d("ololo", "onClick: " + details);
//                }
//                int mLowerCalyxRight = Integer.parseInt(mLowerCalyxRightEdit.getText().toString());
//                if (mLowerCalyxRight>0){
//                    details = "Камень нижней чашечки справа с размером " + mLowerCalyxRight+ " мм";
//                    single++;
//                    Log.d("ololo", "onClick: " + details);
//                }
//                int mPelvisRight = Integer.parseInt(mPelvisRightEdit.getText().toString());
//                if (mPelvisRight>0){
//                    single++;
//                    details += "Камень почечной лоханки справа с размером  " + mPelvisRight;
//                    Log.d("ololo", "onClick: " +""+ details);
//                }
//                int mUpperUreterRight = Integer.parseInt(mUpperUreterRightEdit.getText().toString());
//                if (mUpperUreterRight>0){
//                    single++;
//                    details += "Камень верхней треть мочечточника справа с размером " + mUpperUreterRight;
//                    Log.d("ololo", "onClick: " +""+ details);
//                }
//                int mMiddleUreterRight = Integer.parseInt(mMiddleUreterRightEdit.getText().toString());
//                if (mMiddleUreterRight>0){
//                    single++;
//                    details += "Камень средней треть мочечточника справа с размером " + mMiddleUreterRight;
//                    Log.d("ololo", "onClick: " +""+ details);
//                }
//                int mLowerPartOfTheUreterRight = Integer.parseInt(mLowerPartOfTheUreterRightEdit
//                        .getText().toString());
//                if (mLowerPartOfTheUreterRight>0){
//                    single++;
//                    details += "Камень нижнего (дистальный) отдела  мочеточника справа с размером "
//                            + mLowerPartOfTheUreterRight;
//                    Log.d("ololo", "onClick: " +""+ details);
//                }

                if (single==1){
                    result += "МКБ.Одиночный камень.";
                    Log.d("ololo", "onClick: " + result);
                }else if (single>1){
                    result += "МКБ.Множественный камень.";
                    Log.d("ololo", "onClick: " + result);
                }
                Log.d("ololo", "onClick: " +details);
                Log.d("ololo", "onClick: " +result);
            }
        });
    }
}