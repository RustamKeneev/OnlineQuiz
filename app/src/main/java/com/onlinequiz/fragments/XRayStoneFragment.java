package com.onlinequiz.fragments;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.onlinequiz.R;

public class XRayStoneFragment extends Fragment {

    private LinearLayout mExpandableLayoutXRay;
    private CardView mXRayStoneCard;
    private ImageView mXRayStoneImage;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_x_ray_stone, container, false);
        mExpandableLayoutXRay = view.findViewById(R.id.by_x_ray_characteristics_layout);
        mXRayStoneCard = view.findViewById(R.id.x_ray_stone_card);
        mXRayStoneImage = view.findViewById(R.id.x_ray_stone_image);


        mXRayStoneCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mExpandableLayoutXRay.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(mXRayStoneCard,new AutoTransition());
                    mExpandableLayoutXRay.setVisibility(View.VISIBLE);
                    mXRayStoneImage.setBackgroundResource(R.drawable.ic_arrow_up);
                }else {
                    TransitionManager.beginDelayedTransition(mXRayStoneCard,new AutoTransition());
                    mExpandableLayoutXRay.setVisibility(View.GONE);
                    mXRayStoneImage.setBackgroundResource(R.drawable.ic_arrow_down);
                }
            }
        });
        return view;
    }
}