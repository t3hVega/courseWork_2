package com.coursework.coursework2.service.examiner.implementation;

import com.coursework.coursework2.error.NumberRequestedExceedsAvailableAmount;
import com.coursework.coursework2.model.base.QuestionPaper;
import com.coursework.coursework2.model.java.JavaQuestionPaper;
import com.coursework.coursework2.model.math.MathQuestionPaper;
import com.coursework.coursework2.service.java.implementation.JavaQuestionPaperServiceImpl;
import com.coursework.coursework2.service.math.impl.MathQuestionPaperServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.ExpectedCount.times;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionPaperServiceImpl javaQuestionPaperService;
    @Mock
    private MathQuestionPaperServiceImpl mathQuestionPaperService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;
    ArrayList<JavaQuestionPaper> javaQuestionPapers= new ArrayList<>() {{
        add(new JavaQuestionPaper("Что?", "Оно"));
        add(new JavaQuestionPaper("Где?", "Там"));
        add(new JavaQuestionPaper("Когда?", "Тогда"));
    }};

    ArrayList<MathQuestionPaper> mathQuestionPapers= new ArrayList<>() {{
        add(new MathQuestionPaper("1 + 1", 2));
        add(new MathQuestionPaper("2 + 2", 4));
        add(new MathQuestionPaper("3 + 3", 6));
    }};
    @Test
    void shouldCorrectlyGenerateQuestions() {

        when(javaQuestionPaperService.getAll()).thenReturn(javaQuestionPapers);
        when(mathQuestionPaperService.getAll()).thenReturn(mathQuestionPapers);
        when(javaQuestionPaperService.getRandomQuestionPaper()).thenReturn(
                javaQuestionPapers.get(0),
                javaQuestionPapers.get(1),
                javaQuestionPapers.get(1));
        when(mathQuestionPaperService.getRandomQuestionPaper()).thenReturn(
                mathQuestionPapers.get(1),
                mathQuestionPapers.get(1),
                mathQuestionPapers.get(2));
        Collection<QuestionPaper> expected = new HashSet<>() {{
            add(new JavaQuestionPaper("Что?", "Оно"));
            add(new JavaQuestionPaper("Где?", "Там"));
            add(new MathQuestionPaper("2 + 2", 4));
            add(new MathQuestionPaper("3 + 3", 6));
        }};
        Collection<QuestionPaper> actual = examinerService.getAllQuestions(4);
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(expected.size(), actual.size());
    }

    @Test
    void shouldThrowNumberRequestedExceedsAvailableAmountError() {
        when(javaQuestionPaperService.getAll()).thenReturn(javaQuestionPapers);
        when(mathQuestionPaperService.getAll()).thenReturn(mathQuestionPapers);
        Assertions.assertThrows(NumberRequestedExceedsAvailableAmount.class, () ->
        {Collection<QuestionPaper> actual = examinerService.getAllQuestions(7);});
    }
}