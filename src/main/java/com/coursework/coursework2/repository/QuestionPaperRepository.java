package com.coursework.coursework2.repository;

import com.coursework.coursework2.model.base.QuestionPaper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface QuestionPaperRepository {
    QuestionPaper add(QuestionPaper questionPaper);
    QuestionPaper remove(QuestionPaper questionPaper);
    ArrayList<QuestionPaper> getAll();
}
