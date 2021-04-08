package com.onlinequiz.model;

import java.util.List;

public class AnswerPostModel {
    List<Integer> ids;

    public AnswerPostModel(List<Integer> ids) {
        this.ids = ids;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
