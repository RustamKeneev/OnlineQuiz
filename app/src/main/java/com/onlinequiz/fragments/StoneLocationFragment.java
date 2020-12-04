package com.onlinequiz.fragments;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Toast;

import com.onlinequiz.R;

public class StoneLocationFragment extends Fragment {

    private ConstraintLayout mExpandableLayoutRight;
    private ConstraintLayout mExpandableLayoutLeft;
    private ConstraintLayout mExpandableLayoutStoneLocation;
    private ConstraintLayout mExpandableLayoutStoneByClinic;
    private ImageView mArrowButtonRight;
    private ImageView mArrowButtonLeft;
    private ImageView mArrowButtonStoneLocation;
    private ImageView mArrowButtonStonebyClinic;
    private CardView mCardViewRight;
    private CardView mCardViewLeft;
    private CardView mCardViewStoneLocation;
    private CardView mCardViewStoneByClinic;



    private Button mStoneResultButton;
    public EditText mUpperCalyxRightEdit;

    String result = "";
    String details = "";
    int single = 0;


    public StoneLocationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_stone_location, container, false);

//        mStoneResultButton = (Button) view.findViewById(R.id.stone_result_button);
        mUpperCalyxRightEdit = (EditText) view.findViewById(R.id.upper_calyx_right_edit);

//        mStoneResultButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int mUpperCalyxRight = Integer.parseInt(mUpperCalyxRightEdit.getText().toString().trim());
//                if (mUpperCalyxRight>0){
//                    details += "Камень верхней чашечки справа с размером " + mUpperCalyxRight;
//                    Log.d("ololo", "onClick: " + details.length());
//                }
//
//            }
//        });


        mExpandableLayoutRight = view.findViewById(R.id.expandable_constraint_layout_right);
        mExpandableLayoutLeft = view.findViewById(R.id.expandable_constraint_layout_left);
        mExpandableLayoutStoneLocation = view.findViewById(R.id.stone_location_layout);
        mExpandableLayoutStoneByClinic = view.findViewById(R.id.stone_by_clinic_layout);

        mCardViewRight = view.findViewById(R.id.stone_location_right_card_view);
        mCardViewLeft = view.findViewById(R.id.stone_location_left_card_view);
        mCardViewStoneLocation = view.findViewById(R.id.stone_location_card_view);
        mCardViewStoneByClinic = view.findViewById(R.id.stone_by_clinic_card_view);

        mArrowButtonRight = view.findViewById(R.id.drop_down_right_button);
        mArrowButtonLeft = view.findViewById(R.id.drop_down_left_button);
        mArrowButtonStoneLocation = view.findViewById(R.id.drop_down_button);
        mArrowButtonStonebyClinic = view.findViewById(R.id.stone_by_clinic_button);

        mCardViewRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mExpandableLayoutRight.getVisibility() == View.GONE){
                    TransitionManager.beginDelayedTransition(mCardViewRight,new AutoTransition());
                    mExpandableLayoutRight.setVisibility(View.VISIBLE);
                    mArrowButtonRight.setBackgroundResource(R.drawable.ic_arrow_up);
                }else {
                    TransitionManager.beginDelayedTransition(mCardViewRight,new AutoTransition());
                    mExpandableLayoutRight.setVisibility(View.GONE);
                    mArrowButtonRight.setBackgroundResource(R.drawable.ic_arrow_down);
                }
            }
        });

        mCardViewLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mExpandableLayoutLeft.getVisibility() == View.GONE){
                    TransitionManager.beginDelayedTransition(mCardViewLeft,new AutoTransition());
                    mExpandableLayoutLeft.setVisibility(View.VISIBLE);
                    mArrowButtonLeft.setBackgroundResource(R.drawable.ic_arrow_up);
                }else {
                    TransitionManager.beginDelayedTransition(mCardViewLeft, new AutoTransition());
                    mExpandableLayoutLeft.setVisibility(View.GONE);
                    mArrowButtonLeft.setBackgroundResource(R.drawable.ic_arrow_down);
                }
            }
        });

        mCardViewStoneLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mExpandableLayoutStoneLocation.getVisibility() == View.GONE){
                    TransitionManager.beginDelayedTransition(mCardViewStoneLocation,new AutoTransition());
                    mExpandableLayoutStoneLocation.setVisibility(View.VISIBLE);
                    mArrowButtonStoneLocation.setBackgroundResource(R.drawable.ic_arrow_up);
                }else {
                    TransitionManager.beginDelayedTransition(mCardViewStoneLocation,new AutoTransition());
                    mExpandableLayoutStoneLocation.setVisibility(View.GONE);
                    mArrowButtonStoneLocation.setBackgroundResource(R.drawable.ic_arrow_down);
                }
            }
        });

        mCardViewStoneByClinic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mExpandableLayoutStoneByClinic.getVisibility() == View.GONE){
                    TransitionManager.beginDelayedTransition(mCardViewStoneByClinic, new AutoTransition());
                    mExpandableLayoutStoneByClinic.setVisibility(View.VISIBLE);
                    mArrowButtonStonebyClinic.setBackgroundResource(R.drawable.ic_arrow_up);
                }else {
                    TransitionManager.beginDelayedTransition(mCardViewStoneByClinic,new AutoTransition());
                    mExpandableLayoutStoneByClinic.setVisibility(View.GONE);
                    mArrowButtonStonebyClinic.setBackgroundResource(R.drawable.ic_arrow_down);
                }
            }
        });

        return view;
    }
}