package com.coursework.coursework2.controller.java;

import com.coursework.coursework2.model.java.JavaQuestionPaper;
import com.coursework.coursework2.service.java.JavaQuestionPaperService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/exam")
public class JavaQuestionPaperController {
    private final JavaQuestionPaperService javaQuestionPaperService;

    public JavaQuestionPaperController(JavaQuestionPaperService javaQuestionPaperService) {
        this.javaQuestionPaperService = javaQuestionPaperService;
    }

    @GetMapping("/java/add")
    public JavaQuestionPaper addQuestion(
            @RequestParam("question") String questionText,
            @RequestParam("answer") String answerText
    ) {
        return javaQuestionPaperService.add(questionText, answerText);
    }

    @GetMapping("/java/remove")
    public JavaQuestionPaper removeQuestion(
            @RequestParam("question") String questionText,
            @RequestParam("answer") String answerText
    ) {
        return javaQuestionPaperService.remove(questionText, answerText);
    }

    @GetMapping("/java")
    public ArrayList<JavaQuestionPaper> getQuestions() {
        return javaQuestionPaperService.getAll();
    }
}
