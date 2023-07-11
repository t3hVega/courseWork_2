package com.coursework.coursework2.model.math;

import com.coursework.coursework2.model.base.QuestionPaper;

import java.util.Objects;

public class MathQuestionPaper extends QuestionPaper {
    private Integer answer;
    public MathQuestionPaper(String question, Integer answer) {
        super(question, answer.toString());
    }
}
