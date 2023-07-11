package com.coursework.coursework2.repository.math.impl;

import com.coursework.coursework2.error.QuestionPaperAbsent;
import com.coursework.coursework2.model.base.QuestionPaper;
import com.coursework.coursework2.model.math.MathQuestionPaper;
import com.coursework.coursework2.repository.MathQuestionPaperRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

public class MathQuestionPaperRepositoryImplTest {

    private MathQuestionPaperRepository mathQuestionPaperRepository = new MathQuestionPaperRepository();

    @Test
    void shouldCorrectlyAddQuestionPaper() {

        QuestionPaper mathQuestionPaper = new MathQuestionPaper("2 + 2", 4);
        QuestionPaper expected = new MathQuestionPaper("2 + 2", 4);
        QuestionPaper actual = mathQuestionPaperRepository.add(mathQuestionPaper);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void shouldCorrectlyRemoveQuestionPaper() {

        QuestionPaper mathQuestionPaper = new MathQuestionPaper("2 + 2", 4);
        mathQuestionPaperRepository.add(mathQuestionPaper);
        QuestionPaper expected = new MathQuestionPaper("2 + 2", 4);
        QuestionPaper actual = mathQuestionPaperRepository.remove(mathQuestionPaper);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void shouldCorrectlyThrowQuestionPaperAbsentErrorWhenRemovingNonExistentQuestionPaper () {
        QuestionPaper nonExistent = new MathQuestionPaper("1 + 1", 2);
        QuestionPaper mathQuestionPaper = new MathQuestionPaper("2 + 2", 4);
        QuestionPaper existent = mathQuestionPaperRepository.add(mathQuestionPaper);
        Assertions.assertThrows(QuestionPaperAbsent.class, () -> {
            mathQuestionPaperRepository.remove(nonExistent);
        });
    }

    @Test
    void getAll() {
        Collection<QuestionPaper> expected = new ArrayList<>();
        MathQuestionPaper questionPaper1 = new MathQuestionPaper("1 + 1", 2);
        MathQuestionPaper questionPaper2 = new MathQuestionPaper("2 + 2", 4);
        MathQuestionPaper questionPaper3 = new MathQuestionPaper("3 + 3", 6);

        expected.add(questionPaper1);
        expected.add(questionPaper2);
        expected.add(questionPaper3);
        mathQuestionPaperRepository.add(questionPaper1);
        mathQuestionPaperRepository.add(questionPaper2);
        mathQuestionPaperRepository.add(questionPaper3);
        Collection<QuestionPaper> actual = mathQuestionPaperRepository.getAll();
        Assertions.assertEquals(expected, actual);
    }
}