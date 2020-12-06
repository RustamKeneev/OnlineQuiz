package com.onlinequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.checkbox.MaterialCheckBox;
import com.onlinequiz.fragments.ByEtiologyFragment;
import com.onlinequiz.fragments.StoneLocationFragment;
import com.onlinequiz.fragments.XRayStoneFragment;

public class ThirdActivity extends AppCompatActivity {

    private Button mStoneResultButton;

    //Right Stone Location
    private EditText mUpperCalyxRightEdit;
    private EditText mMiddleCalyxRightEdit;
    private EditText mLowerCalyxRightEdit;
    private EditText mPelvisRightEdit;
    private EditText mUpperUreterRightEdit;
    private EditText mMiddleUreterRightEdit;
    private EditText mLowerPartOfTheUreterRightEdit;

    //Left Stone Location
    private EditText mUpperCalyxLeftEdit;
    private EditText mMiddleCalyxLeftEdit;
    private EditText mLowerCalyxLeftEdit;
    private EditText mPelvisLeftEdit;
    private EditText mUpperUreterLeftEdit;
    private EditText mMiddleUreterLeftEdit;
    private EditText mLowerPartOfTheUreterLeftEdit;

    //Stone Location Bladder And Urethra
    private EditText mBladderEdit;
    private EditText mUrethraEdit;

    //Stone By Clinic
    private MaterialCheckBox mPrimaryCheckbox;


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
                String clinic = "";

                //RIGHT STONE LOCATION
                mUpperCalyxRightEdit = findViewById(R.id.upper_calyx_right_edit);
                mMiddleCalyxRightEdit = findViewById(R.id.middle_calyx_right_edit);
                mLowerCalyxRightEdit = findViewById(R.id.lower_calyx_right_edit);
                mPelvisRightEdit = findViewById(R.id.pelvis_right_edit);
                mUpperUreterRightEdit = findViewById(R.id.upper_ureter_right_edit);
                mMiddleUreterRightEdit = findViewById(R.id.middle_ureter_right_edit);
                mLowerPartOfTheUreterRightEdit = findViewById(R.id.lower_part_of_the_ureter_right_edit);

                //LEFT STONE LOCATION
                mUpperCalyxLeftEdit = findViewById(R.id.upper_calyx_left_edit);
                mMiddleCalyxLeftEdit = findViewById(R.id.middle_calyx_left_edit);
                mLowerCalyxLeftEdit = findViewById(R.id.lower_calyx_left_edit);
                mPelvisLeftEdit = findViewById(R.id.pelvis_left_edit);
                mUpperUreterLeftEdit = findViewById(R.id.upper_ureter_left_edit);
                mMiddleUreterLeftEdit = findViewById(R.id.middle_ureter_left_edit);
                mLowerPartOfTheUreterLeftEdit = findViewById(R.id.lower_part_of_the_ureter_left_edit);

                //STONE LOCATION BLADDER AND URETHRA
                mBladderEdit = findViewById(R.id.bladder_edit);
                mUrethraEdit = findViewById(R.id.urethra_edit);

                //STONE BY CLINIC
                mPrimaryCheckbox = findViewById(R.id.primary_checkbox);

                try {
                    //RIGHT STONE LOCATION
                    if (mUpperCalyxRightEdit.getText().toString().isEmpty()) {
                    }else {
                        int mUpperCalyxRight = Integer.parseInt(mUpperCalyxRightEdit.getText().toString());
                        if (mUpperCalyxRight > 0) {
                            details += "Камень верхней чашечки справа с размером " + mUpperCalyxRight + "мм ";
                            single++;
                            Log.d("ololo", "onClick: " + details);
                        }
                    }
                    if (mMiddleCalyxRightEdit.getText().toString().isEmpty()){
                    }else {
                        int mMiddleCalyxRight = Integer.parseInt(mMiddleCalyxRightEdit.getText().toString());
                        if (mMiddleCalyxRight > 0) {
                            details +="Камень средней чашечки справа с размером " + mMiddleCalyxRight + "мм ";
                            single++;
                            Log.d("ololo", "onClick: " + details);
                        }
                    }
                    if (mLowerCalyxRightEdit.getText().toString().isEmpty()){
                    }else {
                        int mLowerCalyxRight = Integer.parseInt(mLowerCalyxRightEdit.getText().toString());
                        if (mLowerCalyxRight > 0) {
                            details += "Камень нижней чашечки справа с размером " + mLowerCalyxRight+ "мм ";
                            single++;
                            Log.d("ololo", "onClick: " + details);
                        }
                    }
                    if (mPelvisRightEdit.getText().toString().isEmpty()){
                    }else {
                        int mPelvisRight = Integer.parseInt(mPelvisRightEdit.getText().toString());
                        if (mPelvisRight > 0) {
                            single++;
                            details += "Камень почечной лоханки справа с размером  " + mPelvisRight + "мм ";
                            Log.d("ololo", "onClick: " + "" + details);
                        }
                    }
                    if (mUpperUreterRightEdit.getText().toString().isEmpty()){
                    }else {
                        int mUpperUreterRight = Integer.parseInt(mUpperUreterRightEdit.getText().toString());
                        if (mUpperUreterRight > 0) {
                            single++;
                            details = "Камень верхней треть мочечточника справа с размером " + mUpperUreterRight + "мм ";
                            Log.d("ololo", "onClick: " + "" + details);
                        }
                    }
                    if (mMiddleUreterRightEdit.getText().toString().isEmpty()){
                    }else {
                        int mMiddleUreterRight = Integer.parseInt(mMiddleUreterRightEdit.getText().toString());
                        if (mMiddleUreterRight > 0) {
                            single++;
                            details += "Камень средней треть мочечточника справа с размером " + mMiddleUreterRight + "мм ";
                            Log.d("ololo", "onClick: " + "" + details);
                        }
                    }
                    if (mLowerPartOfTheUreterRightEdit.getText().toString().isEmpty()){
                    }else {
                        int mLowerPartOfTheUreterRight = Integer.parseInt(mLowerPartOfTheUreterRightEdit
                                .getText().toString());
                        if (mLowerPartOfTheUreterRight > 0) {
                            single++;
                            details += " Камень нижнего (дистальный) отдела  мочеточника справа с размером "
                                    + mLowerPartOfTheUreterRight + "мм ";
                            Log.d("ololo", "onClick: " + "" + details);
                        }
                    }

                    //LEFT STONE LOCATION
                    if (mUpperCalyxLeftEdit.getText().toString().isEmpty()){
                    }else {
                        int mUpperCalyxLeft = Integer.parseInt(mUpperCalyxLeftEdit.getText().toString());
                        if (mUpperCalyxLeft>0){
                            single++;
                            details += "Камень верхней чашечки  слева с размером " + mUpperCalyxLeft + "мм ";
                        }
                    }
                    if (mMiddleCalyxLeftEdit.getText().toString().isEmpty()){
                    }else {
                        int mMiddleCalyxLeft = Integer.parseInt(mMiddleCalyxLeftEdit.getText().toString());
                        if (mMiddleCalyxLeft>0){
                            single++;
                            details += "Камень средней чашечки слева с  размером " + mMiddleCalyxLeft + "мм ";
                        }
                    }
                    if (mLowerCalyxLeftEdit.getText().toString().isEmpty()){
                    }else {
                        int mLowerCalyxLeft = Integer.parseInt(mLowerCalyxLeftEdit.getText().toString());
                        if (mLowerCalyxLeft>0){
                            single++;
                            details += "Камень нижней чашечки слева с размером " + mLowerCalyxLeft + "мм ";
                        }
                    }
                    if (mPelvisLeftEdit.getText().toString().isEmpty()){
                    }else {
                        int mPelvisLeft = Integer.parseInt(mPelvisLeftEdit.getText().toString());
                        if (mPelvisLeft>0){
                            single++;
                            details += "Камень почечной лоханки слева с размером " + mPelvisLeft + "мм ";
                        }
                    }
                    if (mUpperUreterLeftEdit.getText().toString().isEmpty()){
                    }else {
                        int mUpperUreterLeft = Integer.parseInt(mUpperUreterLeftEdit.getText().toString());
                        if (mUpperUreterLeft>0){
                            single++;
                            details = "Камень верхней трертьи мочечточника слева с  размером " +
                                    mUpperUreterLeft + "мм ";
                        }
                    }
                    if (mMiddleUreterLeftEdit.getText().toString().isEmpty()){
                    }else {
                        int mMiddleUreterLeft = Integer.parseInt(mMiddleUreterLeftEdit.getText().toString());
                        if (mMiddleUreterLeft>0){
                            single++;
                            details += "Камень средней третьи мочеточника слева с  размером " +
                                    mMiddleUreterLeft + "мм ";
                        }
                    }
                    if (mLowerPartOfTheUreterLeftEdit.getText().toString().isEmpty()){
                    }else {
                        int mLowerPartOfTheUreterLeft = Integer.parseInt(mLowerPartOfTheUreterLeftEdit
                        .getText().toString());
                        if (mLowerPartOfTheUreterLeft>0) {
                            single++;
                            details += "Камень нижнего (дистальный) отдела мочеточника слева с  размером " + mLowerPartOfTheUreterLeft + "мм ";
                        }
                    }

                    //STONE LOCATION BLADDER AND URETHRA
                    if (mBladderEdit.getText().toString().isEmpty()){
                    }else {
                        int mBladder = Integer.parseInt(mBladderEdit.getText().toString());
                        if (mBladder>0){
                            single++;
                            details += "Камень мочевого пузыря с размером " + mBladder + "мм ";
                        }
                    }
                    if (mUrethraEdit.getText().toString().isEmpty()){
                    }else {
                        int mUrethra = Integer.parseInt(mUrethraEdit.getText().toString());
                        if (mUrethra>0){
                            single++;
                            details += "Камень уретры с  размером " + mUrethra + "мм ";
                        }
                    }

                    //STONE BY CLINIC
                    if (mPrimaryCheckbox.isChecked()){
                        clinic += "первичный ";
                    }


                }catch (NumberFormatException e){
//                     if (mUpperCalyxRightEdit.getText().toString().isEmpty()) {}
//                     if (mMiddleCalyxRightEdit.getText().toString().isEmpty()){}
                }

                if (single == 1){
                    result += "МКБ. Одиночный камень.";
                    Log.d("ololo", "onClick: " + result);
                }else if (single > 1 ) {
                    result += "МКБ. Множественный камень.";
                    Log.d("ololo", "onClick: " + result);
                }

                String clinic1 = !clinic.isEmpty() ? "По клинике: " + clinic : "";


                Intent intent = new Intent(ThirdActivity.this,ResultActivity.class);
                intent.putExtra("result",result);
                intent.putExtra("details",details);
                intent.putExtra("clinic",clinic1);
                startActivity(intent);
//                Log.d("ololo", "onClick: " +details);
//                Log.d("ololo", "onClick: " +result);
            }
        });
    }
}