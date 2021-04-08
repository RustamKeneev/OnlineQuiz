package com.onlinequiz.question.question_adapter;

import com.onlinequiz.model.Description;

public  interface OnCheckedListener {
    void checked(Boolean isChecked, Description description);
}