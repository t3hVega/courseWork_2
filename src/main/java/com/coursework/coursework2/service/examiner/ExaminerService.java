package com.coursework.coursework2.service.examiner;

import com.coursework.coursework2.model.QuestionPaper;

import java.util.Collection;
import java.util.HashSet;

public interface ExaminerService {
    Collection<QuestionPaper> getAllQuestions(int amount);
}
