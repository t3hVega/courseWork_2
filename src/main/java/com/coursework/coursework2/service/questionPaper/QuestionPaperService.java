package com.coursework.coursework2.service.questionPaper;

import com.coursework.coursework2.model.base.QuestionPaper;

import java.util.ArrayList;

public interface QuestionPaperService {
    QuestionPaper add(String question, String answer);
    QuestionPaper remove(String question, String answer);
    ArrayList<QuestionPaper> getAll();
    QuestionPaper getRandomQuestionPaper();
}
