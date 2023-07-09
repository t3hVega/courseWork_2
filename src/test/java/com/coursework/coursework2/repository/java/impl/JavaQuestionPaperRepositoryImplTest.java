package com.coursework.coursework2.repository.java.impl;

import com.coursework.coursework2.error.EntityAlreadyPresent;
import com.coursework.coursework2.error.QuestionPaperAbsent;
import com.coursework.coursework2.error.SameEntitiesGiven;
import com.coursework.coursework2.model.java.JavaQuestionPaper;
import com.coursework.coursework2.repository.java.JavaQuestionPaperRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

public class JavaQuestionPaperRepositoryImplTest {


    private JavaQuestionPaperRepositoryImpl javaQuestionPaperRepository = new JavaQuestionPaperRepositoryImpl();

    @Test
    void shouldCorrectlyAddQuestionPaper() {

        JavaQuestionPaper javaQuestionPaper = new JavaQuestionPaper("Что?", "Оно");
        JavaQuestionPaper expected = new JavaQuestionPaper("Что?", "Оно");
        JavaQuestionPaper actual = javaQuestionPaperRepository.add(javaQuestionPaper);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void shouldCorrectlyRemoveQuestionPaper() {

        JavaQuestionPaper javaQuestionPaper = new JavaQuestionPaper("Что?", "Оно");
        javaQuestionPaperRepository.add(javaQuestionPaper);
        JavaQuestionPaper expected = new JavaQuestionPaper("Что?", "Оно");
        JavaQuestionPaper actual = javaQuestionPaperRepository.remove(javaQuestionPaper);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void shouldCorrectlyThrowQuestionPaperAbsentErrorWhenRemovingNonExistentQuestionPaper () {
        JavaQuestionPaper nonExistent = new JavaQuestionPaper("Кто?", "Он");
        JavaQuestionPaper javaQuestionPaper = new JavaQuestionPaper("Что?", "Оно");
        JavaQuestionPaper existent = javaQuestionPaperRepository.add(javaQuestionPaper);
        Assertions.assertThrows(QuestionPaperAbsent.class, () -> {
            javaQuestionPaperRepository.remove(nonExistent);
        });
    }

    @Test
    void getAll() {
        Collection<JavaQuestionPaper> expected = new ArrayList<>();
        JavaQuestionPaper questionPaper1 = new JavaQuestionPaper("Что?", "Оно");
        JavaQuestionPaper questionPaper2 = new JavaQuestionPaper("Где?", "Там");
        JavaQuestionPaper questionPaper3 = new JavaQuestionPaper("Когда?", "Тогда");
        expected.add(questionPaper1);
        expected.add(questionPaper2);
        expected.add(questionPaper3);
        javaQuestionPaperRepository.add(questionPaper1);
        javaQuestionPaperRepository.add(questionPaper2);
        javaQuestionPaperRepository.add(questionPaper3);
        Collection<JavaQuestionPaper> actual = javaQuestionPaperRepository.getAll();
        Assertions.assertEquals(expected, actual);
    }
}