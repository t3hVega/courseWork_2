package com.coursework.coursework2.controller.question;

import com.coursework.coursework2.model.QuestionPaper;
import com.coursework.coursework2.service.question.QuestionPaperService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class JavaController {
    private final QuestionPaperService questionPaperService;

    public JavaController (QuestionPaperService questionPaperService) {
        this.questionPaperService = questionPaperService;
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
        QuestionPaper questionPaper = new QuestionPaper(questionText, answerText);
        return questionPaperService.remove(questionPaper);
    }

    @GetMapping("/java")
    public Collection<QuestionPaper> getQuestions() {
        return questionPaperService.getAll();
    }
}
