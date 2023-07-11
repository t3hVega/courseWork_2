package com.coursework.coursework2.repository.java.impl;

import com.coursework.coursework2.error.QuestionPaperAbsent;
import com.coursework.coursework2.model.base.QuestionPaper;
import com.coursework.coursework2.model.java.JavaQuestionPaper;
import com.coursework.coursework2.repository.JavaQuestionPaperRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

public class JavaQuestionPaperRepositoryImplTest {


    private JavaQuestionPaperRepository javaQuestionPaperRepository = new JavaQuestionPaperRepository();

    @Test
    void shouldCorrectlyAddQuestionPaper() {

        QuestionPaper javaQuestionPaper = new JavaQuestionPaper("Что?", "Оно");
        QuestionPaper expected = new JavaQuestionPaper("Что?", "Оно");
        QuestionPaper actual = javaQuestionPaperRepository.add(javaQuestionPaper);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void shouldCorrectlyRemoveQuestionPaper() {

        QuestionPaper javaQuestionPaper = new JavaQuestionPaper("Что?", "Оно");
        javaQuestionPaperRepository.add(javaQuestionPaper);
        QuestionPaper expected = new JavaQuestionPaper("Что?", "Оно");
        QuestionPaper actual = javaQuestionPaperRepository.remove(javaQuestionPaper);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void shouldCorrectlyThrowQuestionPaperAbsentErrorWhenRemovingNonExistentQuestionPaper () {
        QuestionPaper nonExistent = new JavaQuestionPaper("Кто?", "Он");
        QuestionPaper javaQuestionPaper = new JavaQuestionPaper("Что?", "Оно");
        QuestionPaper existent = javaQuestionPaperRepository.add(javaQuestionPaper);
        Assertions.assertThrows(QuestionPaperAbsent.class, () -> {
            javaQuestionPaperRepository.remove(nonExistent);
        });
    }

    @Test
    void getAll() {
        Collection<QuestionPaper> expected = new ArrayList<>();
        JavaQuestionPaper questionPaper1 = new JavaQuestionPaper("Что?", "Оно");
        JavaQuestionPaper questionPaper2 = new JavaQuestionPaper("Где?", "Там");
        JavaQuestionPaper questionPaper3 = new JavaQuestionPaper("Когда?", "Тогда");

        expected.add(questionPaper1);
        expected.add(questionPaper2);
        expected.add(questionPaper3);
        javaQuestionPaperRepository.add(questionPaper1);
        javaQuestionPaperRepository.add(questionPaper2);
        javaQuestionPaperRepository.add(questionPaper3);
        Collection<QuestionPaper> actual = javaQuestionPaperRepository.getAll();
        Assertions.assertEquals(expected, actual);
    }
}