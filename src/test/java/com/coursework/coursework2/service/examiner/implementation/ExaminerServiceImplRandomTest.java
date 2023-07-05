package com.coursework.coursework2.service.examiner.implementation;

import com.coursework.coursework2.model.QuestionPaper;
import com.coursework.coursework2.service.question.implementation.JavaQuestionPaperService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplRandomTest {

    @Mock
    private JavaQuestionPaperService questionPaperService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    ArrayList<QuestionPaper> forSetUp = new ArrayList<>() {{
        add(new QuestionPaper("Что?", "Оно"));
        add(new QuestionPaper("Где?", "Там"));
        add(new QuestionPaper("Когда?", "Тогда"));
    }};

    @BeforeEach
    public void setUpGetAll() {
        when(questionPaperService.getAll()).thenReturn(forSetUp);
    }

    @BeforeEach
    public void setUpGetRandomQuestion() {
        Random rand = new Random();
        when(questionPaperService.getRandomQuestionPaper(questionPaperService.getAll())).
                thenReturn(forSetUp.get(rand.nextInt(forSetUp.size())));
    }

    @Test
    void shouldCorrectlyGenerateRandomQuestionPaperFromQuestionPapersArrayOutcome1() {
        Collection<QuestionPaper> expectedOutcome1 = new HashSet<>() {{
            add(new QuestionPaper("Что?", "Оно"));
        }};

        Collection<QuestionPaper> actualOutcome = examinerService.getAllQuestions(1);
        Assertions.assertEquals(expectedOutcome1, actualOutcome);
    }

    @Test
    void shouldCorrectlyGenerateRandomQuestionPaperFromQuestionPapersArrayOutcome2() {
        Collection<QuestionPaper> expectedOutcome2 = new HashSet<>() {{
            add(new QuestionPaper("Где?", "Там"));
        }};

        Collection<QuestionPaper> actualOutcome = examinerService.getAllQuestions(1);
        Assertions.assertEquals(expectedOutcome2, actualOutcome);
    }

    @Test
    void shouldCorrectlyGenerateRandomQuestionPaperFromQuestionPapersArrayOutcome3() {
        Collection<QuestionPaper> expectedOutcome3 = new HashSet<>() {{
            add(new QuestionPaper("Когда?", "Тогда"));
        }};

        Collection<QuestionPaper> actualOutcome = examinerService.getAllQuestions(1);
        Assertions.assertEquals(expectedOutcome3, actualOutcome);
    }



}