package com.coursework.coursework2.repository.math.impl;

import com.coursework.coursework2.error.QuestionPaperAbsent;
import com.coursework.coursework2.model.java.JavaQuestionPaper;
import com.coursework.coursework2.model.math.MathQuestionPaper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class MathQuestionPaperRepositoryImplTest {

    private MathQuestionPaperRepositoryImpl mathQuestionPaperRepository = new MathQuestionPaperRepositoryImpl();

    @Test
    void shouldCorrectlyAddQuestionPaper() {

        MathQuestionPaper mathQuestionPaper = new MathQuestionPaper("2 + 2", 4);
        MathQuestionPaper expected = new MathQuestionPaper("2 + 2", 4);
        MathQuestionPaper actual = mathQuestionPaperRepository.add(mathQuestionPaper);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void shouldCorrectlyRemoveQuestionPaper() {

        MathQuestionPaper mathQuestionPaper = new MathQuestionPaper("2 + 2", 4);
        mathQuestionPaperRepository.add(mathQuestionPaper);
        MathQuestionPaper expected = new MathQuestionPaper("2 + 2", 4);
        MathQuestionPaper actual = mathQuestionPaperRepository.remove(mathQuestionPaper);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void shouldCorrectlyThrowQuestionPaperAbsentErrorWhenRemovingNonExistentQuestionPaper () {
        MathQuestionPaper nonExistent = new MathQuestionPaper("1 + 1", 2);
        MathQuestionPaper mathQuestionPaper = new MathQuestionPaper("2 + 2", 4);
        MathQuestionPaper existent = mathQuestionPaperRepository.add(mathQuestionPaper);
        Assertions.assertThrows(QuestionPaperAbsent.class, () -> {
            mathQuestionPaperRepository.remove(nonExistent);
        });
    }

    @Test
    void getAll() {
        Collection<MathQuestionPaper> expected = new ArrayList<>();
        MathQuestionPaper questionPaper1 = new MathQuestionPaper("1 + 1", 2);
        MathQuestionPaper questionPaper2 = new MathQuestionPaper("2 + 2", 4);
        MathQuestionPaper questionPaper3 = new MathQuestionPaper("3 + 3", 6);
        expected.add(questionPaper1);
        expected.add(questionPaper2);
        expected.add(questionPaper3);
        mathQuestionPaperRepository.add(questionPaper1);
        mathQuestionPaperRepository.add(questionPaper2);
        mathQuestionPaperRepository.add(questionPaper3);
        Collection<MathQuestionPaper> actual = mathQuestionPaperRepository.getAll();
        Assertions.assertEquals(expected, actual);
    }
}