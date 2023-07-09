package com.coursework.coursework2.service.math.impl;

import com.coursework.coursework2.error.EntityAlreadyPresent;
import com.coursework.coursework2.model.math.MathQuestionPaper;
import com.coursework.coursework2.repository.math.impl.MathQuestionPaperRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MathQuestionPaperServiceImplTest {

    @Mock
    private MathQuestionPaperRepositoryImpl mathQuestionPaperRepository;

    @InjectMocks
    private MathQuestionPaperServiceImpl mathQuestionPaperService;

    @Test
    void shouldReturnTrueWhenQuestionIsPresent() {
        ArrayList<MathQuestionPaper> questionPapers = new ArrayList<>() {{
            add(new MathQuestionPaper("1 + 1", 2));
        }};

        when(mathQuestionPaperRepository.getAll()).thenReturn(questionPapers);
        boolean expected = true;
        boolean actual = mathQuestionPaperService.isQuestionPresent("1 + 1");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldReturnFalseWhenQuestionIsAbsent() {
        ArrayList<MathQuestionPaper> questionPapers = new ArrayList<>() {{
            add(new MathQuestionPaper("1 + 1", 2));
        }};

        when(mathQuestionPaperRepository.getAll()).thenReturn(questionPapers);
        boolean expected = false;
        boolean actual = mathQuestionPaperService.isQuestionPresent("2 + 2");
        Assertions.assertEquals(expected, actual);
    }


    @Test
    void shouldCorrectlyThrowEntityAlreadyPresentErrorWhenAddingSameQuestion() {
        ArrayList<MathQuestionPaper> questionPapers = new ArrayList<>() {{
            add(new MathQuestionPaper("1 + 1", 2));
        }};

        when(mathQuestionPaperRepository.getAll()).thenReturn(questionPapers);
        Assertions.assertThrows(EntityAlreadyPresent.class, () -> {
            mathQuestionPaperService.add("1 + 1", 2);
        });
    }

    @Test
    void shouldCorrectlyAddQuestion() {
        MathQuestionPaper javaQuestionPaper = new MathQuestionPaper("1 + 1", 2);
        when(mathQuestionPaperRepository.add(javaQuestionPaper)).thenReturn(javaQuestionPaper);
        MathQuestionPaper expected = new MathQuestionPaper("1 + 1", 2);
        MathQuestionPaper actual = mathQuestionPaperService.add("1 + 1", 2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCorrectlyRemoveQuestion() {

        MathQuestionPaper javaQuestionPaper = new MathQuestionPaper("1 + 1", 2);
        when(mathQuestionPaperRepository.remove(javaQuestionPaper)).thenReturn(javaQuestionPaper);
        MathQuestionPaper expected = new MathQuestionPaper("1 + 1", 2);
        MathQuestionPaper actual = mathQuestionPaperService.remove("1 + 1", 2);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void getAll() {
        ArrayList<MathQuestionPaper> questionPapers = new ArrayList<>() {{
            add(new MathQuestionPaper("1 + 1", 2));
            add(new MathQuestionPaper("2 + 2", 4));
            add(new MathQuestionPaper("3 + 3", 6));
        }};

        when(mathQuestionPaperRepository.getAll()).thenReturn(questionPapers);

        ArrayList<MathQuestionPaper> expected = new ArrayList<>() {{
            add(new MathQuestionPaper("1 + 1", 2));
            add(new MathQuestionPaper("2 + 2", 4));
            add(new MathQuestionPaper("3 + 3", 6));
        }};
        ArrayList<MathQuestionPaper> actual = mathQuestionPaperService.getAll();
        Assertions.assertEquals(expected, actual);
    }
}