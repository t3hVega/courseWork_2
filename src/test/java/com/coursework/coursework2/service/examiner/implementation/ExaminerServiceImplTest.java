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

import static org.mockito.Mockito.*;

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
        when(questionPaperService.getRandomQuestionPaper()).
                thenReturn(forSetUp.get(0),
                        forSetUp.get(0),
                        forSetUp.get(1));
    }

    @Test
    void shouldCorrectlyGenerateRandomQuestionPapersFromQuestionPapersArray() {
        Collection<QuestionPaper> expected = new HashSet<>() {{
            add(new QuestionPaper("Что?", "Оно"));
            add(new QuestionPaper("Где?", "Там"));
        }};

        Collection<QuestionPaper> actual = examinerService.getAllQuestions(2);

        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(expected.size(), actual.size());
        verify(questionPaperService, times(3)).getRandomQuestionPaper();


    }

    @Test
    void shouldCorrectlyThrowNumberRequestedExceedsAvailableAmountError() {
        Assertions.assertThrows(NumberRequestedExceedsAvailableAmount.class, () -> {
            examinerService.getAllQuestions(4);
        });
    }

}