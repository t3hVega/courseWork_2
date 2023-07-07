package com.coursework.coursework2.service.examiner.implementation;

import com.coursework.coursework2.error.NumberRequestedExceedsAvailableAmount;
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

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

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

    @Test
    void shouldCorrectlyGenerateRandomQuestionPapersFromQuestionPapersArray() {
        boolean expected = true;

        Collection<QuestionPaper> expectedOutcome1 = new HashSet<>() {{
            add(new QuestionPaper("Что?", "Оно"));
            add(new QuestionPaper("Где?", "Там"));
        }};

        Collection<QuestionPaper> expectedOutcome2 = new HashSet<>() {{
            add(new QuestionPaper("Где?", "Там"));
            add(new QuestionPaper("Когда?", "Тогда"));
        }};

        Collection<QuestionPaper> expectedOutcome3 = new HashSet<>() {{
            add(new QuestionPaper("Когда?", "Тогда"));
            add(new QuestionPaper("Что?", "Оно"));
        }};

        Collection<QuestionPaper> actualOutcome = examinerService.getAllQuestions(2);

        boolean actual = actualOutcome.equals(expectedOutcome1) ||
                         actualOutcome.equals(expectedOutcome2) ||
                         actualOutcome.equals(expectedOutcome3);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCorrectlyThrowNumberRequestedExceedsAvailableAmountError() {
        Assertions.assertThrows(NumberRequestedExceedsAvailableAmount.class, () -> {
            examinerService.getAllQuestions(4);
        });
    }

}