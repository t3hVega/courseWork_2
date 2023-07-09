package com.coursework.coursework2.model.java;

import com.coursework.coursework2.model.base.QuestionPaper;

import java.util.Objects;

public class JavaQuestionPaper extends QuestionPaper {

    private String answer;

    public JavaQuestionPaper(String question, String answer) {
        super(question);
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        JavaQuestionPaper that = (JavaQuestionPaper) o;
        return Objects.equals(answer, that.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), answer);
    }
}
