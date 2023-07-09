package com.coursework.coursework2.service.java.implementation;

import com.coursework.coursework2.error.EntityAlreadyPresent;
import com.coursework.coursework2.error.SameEntitiesGiven;
import com.coursework.coursework2.model.java.JavaQuestionPaper;
import com.coursework.coursework2.repository.java.impl.JavaQuestionPaperRepositoryImpl;
import com.coursework.coursework2.service.java.JavaQuestionPaperService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JavaQuestionPaperServiceImplTest {

    @Mock
    private JavaQuestionPaperRepositoryImpl javaQuestionPaperRepository;

    @InjectMocks
    private JavaQuestionPaperServiceImpl javaQuestionPaperService;

    @Test
    void shouldReturnTrueWhenQuestionIsPresent() {
        ArrayList<JavaQuestionPaper> questionPapers = new ArrayList<>() {{
            add(new JavaQuestionPaper("Что?", "Оно"));
        }};

        when(javaQuestionPaperRepository.getAll()).thenReturn(questionPapers);
        boolean expected = true;
        boolean actual = javaQuestionPaperService.isQuestionPresent("Что?");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldReturnFalseWhenQuestionIsAbsent() {
        ArrayList<JavaQuestionPaper> questionPapers = new ArrayList<>() {{
            add(new JavaQuestionPaper("Что?", "Оно"));
        }};

        when(javaQuestionPaperRepository.getAll()).thenReturn(questionPapers);
        boolean expected = false;
        boolean actual = javaQuestionPaperService.isQuestionPresent("Кто?");
         Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldReturnTrueWhenAnswerIsPresent() {
        ArrayList<JavaQuestionPaper> questionPapers = new ArrayList<>() {{
            add(new JavaQuestionPaper("Что?", "Оно"));
        }};

        when(javaQuestionPaperRepository.getAll()).thenReturn(questionPapers);
        boolean expected = true;
        boolean actual = javaQuestionPaperService.isAnswerPresent("Оно");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldReturnFalseWhenAnswerIsAbsent() {
        ArrayList<JavaQuestionPaper> questionPapers = new ArrayList<>() {{
            add(new JavaQuestionPaper("Что?", "Оно"));
        }};

        when(javaQuestionPaperRepository.getAll()).thenReturn(questionPapers);
        boolean expected = false;
        boolean actual = javaQuestionPaperService.isAnswerPresent("Он");
        Assertions.assertEquals(expected, actual);
    }


    @Test
    void shouldCorrectlyThrowEntityAlreadyPresentErrorWhenAddingSameQuestion() {
        ArrayList<JavaQuestionPaper> questionPapers = new ArrayList<>() {{
            add(new JavaQuestionPaper("Что?", "Оно"));
        }};

        when(javaQuestionPaperRepository.getAll()).thenReturn(questionPapers);
        Assertions.assertThrows(EntityAlreadyPresent.class, () -> {
            javaQuestionPaperService.add("Что?", "");
        });
    }

    @Test
    void shouldCorrectlyThrowEntityAlreadyPresentErrorWhenAddingSameAnswer() {
        ArrayList<JavaQuestionPaper> questionPapers = new ArrayList<>() {{
            add(new JavaQuestionPaper("Что?", "Оно"));
        }};

        when(javaQuestionPaperRepository.getAll()).thenReturn(questionPapers);
        Assertions.assertThrows(EntityAlreadyPresent.class, () -> {
            javaQuestionPaperService.add("", "Оно");
        });
    }

    @Test
    void shouldCorrectlyThrowSameEntitiesGivenErrorWhenAddingPairOfIdenticalQuestionAndAnswer() {
        Assertions.assertThrows(SameEntitiesGiven.class, () -> {
            javaQuestionPaperService.add("Кто?", "Кто?");
        });
    }

    @Test
    void shouldCorrectlyAddQuestion() {
        JavaQuestionPaper javaQuestionPaper = new JavaQuestionPaper("Почему?", "Затем");
        when(javaQuestionPaperRepository.add(javaQuestionPaper)).thenReturn(javaQuestionPaper);
        JavaQuestionPaper expected = new JavaQuestionPaper("Почему?", "Затем");
        JavaQuestionPaper actual = javaQuestionPaperService.add("Почему?", "Затем");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCorrectlyRemoveQuestion() {

        JavaQuestionPaper javaQuestionPaper = new JavaQuestionPaper("Почему?", "Затем");
        when(javaQuestionPaperRepository.remove(javaQuestionPaper)).thenReturn(javaQuestionPaper);
        JavaQuestionPaper expected = new JavaQuestionPaper("Почему?", "Затем");
        JavaQuestionPaper actual = javaQuestionPaperService.remove("Почему?", "Затем");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void getAll() {
        ArrayList<JavaQuestionPaper> questionPapers = new ArrayList<>() {{
            add(new JavaQuestionPaper("Что?", "Оно"));
            add(new JavaQuestionPaper("Где?", "Там"));
            add(new JavaQuestionPaper("Когда?", "Тогда"));
        }};

        when(javaQuestionPaperRepository.getAll()).thenReturn(questionPapers);

        ArrayList<JavaQuestionPaper> expected = new ArrayList<>() {{
            add(new JavaQuestionPaper("Что?", "Оно"));
            add(new JavaQuestionPaper("Где?", "Там"));
            add(new JavaQuestionPaper("Когда?", "Тогда"));
        }};
        ArrayList<JavaQuestionPaper> actual = javaQuestionPaperService.getAll();
        Assertions.assertEquals(expected, actual);
    }
}