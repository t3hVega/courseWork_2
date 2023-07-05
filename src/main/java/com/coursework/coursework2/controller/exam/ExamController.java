package com.coursework.coursework2.controller.exam;

import com.coursework.coursework2.model.QuestionPaper;
import com.coursework.coursework2.service.examiner.ExaminerService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public Collection<QuestionPaper> getQuestions(
            @PathVariable(required = false, value = "amount")
            Integer amount
    ) {
        return examinerService.getAllQuestions(amount);
    }
}
