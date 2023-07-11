package com.coursework.coursework2.service.examiner.implementation;

import com.coursework.coursework2.error.NumberRequestedExceedsAvailableAmount;
import com.coursework.coursework2.model.base.QuestionPaper;
import com.coursework.coursework2.service.examiner.ExaminerService;
import com.coursework.coursework2.service.questionPaper.JavaQuestionPaperService;
import com.coursework.coursework2.service.questionPaper.MathQuestionPaperService;
import com.coursework.coursework2.service.questionPaper.QuestionPaperService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    @Qualifier("java")
    private QuestionPaperService javaQuestionPaperService;
    @Qualifier("math")
    private QuestionPaperService mathQuestionPaperService;

    public ExaminerServiceImpl(JavaQuestionPaperService javaQuestionPaperService,
                               MathQuestionPaperService mathQuestionPaperService) {
        this.javaQuestionPaperService = javaQuestionPaperService;
        this.mathQuestionPaperService = mathQuestionPaperService;
    }

    @Override
    public Collection<QuestionPaper> getAllQuestions(int amount) {

        if(amount > javaQuestionPaperService.getAll().size() + mathQuestionPaperService.getAll().size()) {
            throw new NumberRequestedExceedsAvailableAmount("Данное число превышает кол-во вопросов");
        }

        Collection<QuestionPaper> questionPapers = new HashSet<>();
        Random random = new Random();
        while(questionPapers.size() < amount) {
            QuestionPaper questionPaper;
            int pick = random.nextInt(2);
            if(pick == 1) {
                questionPaper = javaQuestionPaperService.getRandomQuestionPaper();
            } else questionPaper = mathQuestionPaperService.getRandomQuestionPaper();
            questionPapers.add(questionPaper);
        }

        return questionPapers;

    }
}
