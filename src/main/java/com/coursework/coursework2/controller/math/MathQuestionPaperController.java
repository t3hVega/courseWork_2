package com.coursework.coursework2.controller.math;

import com.coursework.coursework2.model.base.QuestionPaper;
import com.coursework.coursework2.model.math.MathQuestionPaper;
import com.coursework.coursework2.service.questionPaper.MathQuestionPaperService;
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
public class MathQuestionPaperController {

    @Autowired
    @Qualifier("math")
    private final QuestionPaperService questionPaperService;

    public MathQuestionPaperController(MathQuestionPaperService mathQuestionPaperService) {
        this.questionPaperService = mathQuestionPaperService;
    }

    @GetMapping("/math/add")
    public QuestionPaper addQuestion(
            @RequestParam("question") String questionText,
            @RequestParam("answer") String answerNumber
    ) {
        return questionPaperService.add(questionText, answerNumber);
    }

    @GetMapping("/math/remove")
    public QuestionPaper removeQuestion(
            @RequestParam("question") String questionText,
            @RequestParam("answer") String answerNumber
    ) {
        return questionPaperService.remove(questionText, answerNumber);
    }

    @GetMapping("/math")
    public ArrayList<QuestionPaper> getQuestions() {
        return questionPaperService.getAll();
    }
}
