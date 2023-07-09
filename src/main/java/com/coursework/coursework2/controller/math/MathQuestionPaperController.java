package com.coursework.coursework2.controller.math;

import com.coursework.coursework2.model.base.QuestionPaper;
import com.coursework.coursework2.model.java.JavaQuestionPaper;
import com.coursework.coursework2.model.math.MathQuestionPaper;
import com.coursework.coursework2.service.math.MathQuestionPaperService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/exam")
public class MathQuestionPaperController {
    private final MathQuestionPaperService mathQuestionPaperService;

    public MathQuestionPaperController(MathQuestionPaperService mathQuestionPaperService) {
        this.mathQuestionPaperService = mathQuestionPaperService;
    }

    @GetMapping("/math/add")
    public MathQuestionPaper addQuestion(
            @RequestParam("question") String questionText,
            @RequestParam("answer") Integer answerNumber
    ) {
        return mathQuestionPaperService.add(questionText, answerNumber);
    }

    @GetMapping("/math/remove")
    public QuestionPaper removeQuestion(
            @RequestParam("question") String questionText,
            @RequestParam("answer") Integer answerNumber
    ) {
        return mathQuestionPaperService.remove(questionText, answerNumber);
    }

    @GetMapping("/math")
    public ArrayList<MathQuestionPaper> getQuestions() {
        return mathQuestionPaperService.getAll();
    }
}
