package com.coursework.coursework2.model;

import org.springframework.stereotype.Service;

import java.util.Objects;


public class QuestionPaper {

    private String question;
    private String answer;

    public QuestionPaper(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionPaper questionPaper1 = (QuestionPaper) o;
        return Objects.equals(question, questionPaper1.question) && Objects.equals(answer, questionPaper1.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answer);
    }


    @Override
    public String toString() {
        return "Билет {" +
                "вопрос - '" + question + '\'' +
                ", ответ - '" + answer + '\'' +
                '}';
    }
}
