package com.coursework.coursework2.service.java;

import com.coursework.coursework2.model.java.JavaQuestionPaper;

import java.util.ArrayList;

public interface JavaQuestionPaperService {

    boolean isQuestionPresent(String word);
    boolean isAnswerPresent(String word);
    JavaQuestionPaper add(String question, String answer);
    JavaQuestionPaper remove(String question, String answer);
    ArrayList<JavaQuestionPaper> getAll();
    JavaQuestionPaper getRandomQuestionPaper();
}
