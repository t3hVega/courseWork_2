package com.coursework.coursework2.service.examiner;

import com.coursework.coursework2.model.base.QuestionPaper;

import java.util.Collection;

public interface ExaminerService {
    Collection<QuestionPaper> getAllQuestions(int amount);

}
