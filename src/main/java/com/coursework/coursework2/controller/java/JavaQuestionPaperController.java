package com.coursework.coursework2.controller.java;

import com.coursework.coursework2.model.base.QuestionPaper;
import com.coursework.coursework2.service.questionPaper.JavaQuestionPaperService;
import com.coursework.coursework2.service.questionPaper.QuestionPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/exam")
public class JavaQuestionPaperController {

    @Autowired
    @Qualifier("java")
    private final QuestionPaperService questionPaperService;

    public JavaQuestionPaperController(JavaQuestionPaperService javaQuestionPaperService) {
        this.questionPaperService = javaQuestionPaperService;
    }

    @GetMapping("/java/add")
    public QuestionPaper addQuestion(
            @RequestParam("question") String questionText,
            @RequestParam("answer") String answerText
    ) {
        return questionPaperService.add(questionText, answerText);
    }

    @GetMapping("/java/remove")
    public QuestionPaper removeQuestion(
            @RequestParam("question") String questionText,
            @RequestParam("answer") String answerText
    ) {
        return questionPaperService.remove(questionText, answerText);
    }

    @GetMapping("/java")
    public ArrayList<QuestionPaper> getQuestions() {
        return questionPaperService.getAll();
    }
}
