package com.coursework.coursework2.service.question;

import com.coursework.coursework2.model.QuestionPaper;

import java.util.ArrayList;
import java.util.Collection;

public interface QuestionPaperService {

    QuestionPaper add(String question, String answer);

    QuestionPaper add(QuestionPaper questionPaper);

    QuestionPaper remove(QuestionPaper questionPaper);

    ArrayList<QuestionPaper> getAll();

    QuestionPaper getRandomQuestionPaper();

}
