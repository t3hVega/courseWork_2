package com.coursework.coursework2.service.examiner.implementation;

import com.coursework.coursework2.error.NumberRequestedExceedsAvailableAmount;
import com.coursework.coursework2.model.QuestionPaper;
import com.coursework.coursework2.service.examiner.ExaminerService;
import com.coursework.coursework2.service.question.QuestionPaperService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private QuestionPaperService questionPaperService;

    public ExaminerServiceImpl(QuestionPaperService questionPaperService) {
        this.questionPaperService = questionPaperService;
    }
    @Override
    public Collection<QuestionPaper> getAllQuestions(int amount) {

        if(amount > questionPaperService.getAll().size()) {
            throw new NumberRequestedExceedsAvailableAmount("Данное число превышает кол-во вопросов");
        }

        Collection<QuestionPaper> questionPapers = new HashSet<>();

        for (int i = 0; i < amount; i++) {
            QuestionPaper questionPaper = questionPaperService.getRandomQuestionPaper(questionPaperService.getAll());
            questionPapers.add(questionPaper);
        }
        return questionPapers;
    }
}
