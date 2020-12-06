package com.onlinequiz.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.onlinequiz.R;

public class XRayStoneFragmentResult extends Fragment {

    private TextView mByClinicTextResult;
    private String clinic;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_x_ray_stone_result, container, false);
        mByClinicTextResult = view.findViewById(R.id.by_clinic_text_result);

        clinic = getActivity().getIntent().getStringExtra("clinic");

        mByClinicTextResult.setText(clinic);
        return view;
    }
}