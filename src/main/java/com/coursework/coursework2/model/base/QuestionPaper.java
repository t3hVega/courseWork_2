package com.coursework.coursework2.model.base;

import java.util.Objects;


public class QuestionPaper {

    private String question;

    public QuestionPaper(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionPaper that = (QuestionPaper) o;
        return Objects.equals(question, that.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question);
    }

    @Override
    public String toString() {
        return "QuestionPaper{" +
                "question='" + question + '\'' +
                '}';
    }
}
