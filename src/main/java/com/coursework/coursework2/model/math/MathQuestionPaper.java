package com.coursework.coursework2.model.math;

import com.coursework.coursework2.model.base.QuestionPaper;

import java.util.Objects;

public class MathQuestionPaper extends QuestionPaper {

    private Integer answer;

    public MathQuestionPaper(String question, Integer answer) {
        super(question);
        this.answer = answer;
    }

    public Integer getAnswer() {
        return answer;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MathQuestionPaper that = (MathQuestionPaper) o;
        return Objects.equals(answer, that.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), answer);
    }

    @Override
    public String toString() {
        return "MathQuestionPaper{" +
                "answer=" + answer +
                '}';
    }
}
