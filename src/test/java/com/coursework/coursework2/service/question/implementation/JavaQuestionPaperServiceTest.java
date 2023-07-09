package com.coursework.coursework2.service.question.implementation;

import com.coursework.coursework2.error.EntityAlreadyPresent;
import com.coursework.coursework2.error.QuestionPaperAbsent;
import com.coursework.coursework2.error.SameEntitiesGiven;
import com.coursework.coursework2.model.QuestionPaper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionPaperServiceTest {

    public JavaQuestionPaperService javaQuestionPaperService = new JavaQuestionPaperService();

    @Test
    void shouldReturnTrueWhenQuestionIsPresent() {
        javaQuestionPaperService.add("Что?", "Оно");
        boolean expected = true;
        boolean actual = javaQuestionPaperService.isQuestionPresent("Что?");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void shouldReturnTrueWhenQuestionIsAbsent() {
        javaQuestionPaperService.add("Что?", "Оно");
        boolean expected = false;
        boolean actual = javaQuestionPaperService.isQuestionPresent("Где?");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldReturnTrueWhenAnswerIsPresent() {
        javaQuestionPaperService.add("Что?", "Оно");
        boolean expected = true;
        boolean actual = javaQuestionPaperService.isAnswerPresent("Оно");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldReturnFalseWhenAnswerIsAbsent() {
        javaQuestionPaperService.add("Что?", "Оно");
        boolean expected = false;
        boolean actual = javaQuestionPaperService.isAnswerPresent("Там");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCorrectlyAddQuestionPaper() {
        QuestionPaper expected = new QuestionPaper("Что?", "Оно");
        QuestionPaper actual = javaQuestionPaperService.add("Что?", "Оно");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCorrectlyThrowEntityAlreadyPresentErrorWhenAddingSameQuestion() {
        javaQuestionPaperService.add("Что?", "Оно");
        Assertions.assertThrows(EntityAlreadyPresent.class, () -> {
            javaQuestionPaperService.add("Что?", "");
        });
    }

    @Test
    void shouldCorrectlyThrowEntityAlreadyPresentErrorWhenAddingSameAnswer() {
        javaQuestionPaperService.add("Что?", "Оно");
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
    void shouldCorrectlyAddQuestionPaperViaAddingWholeQuestionPaper() {
        QuestionPaper questionPaper = new QuestionPaper("Что?", "Оно");
        QuestionPaper expected = new QuestionPaper("Что?", "Оно");
        QuestionPaper actual = javaQuestionPaperService.add(questionPaper);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCorrectlyRemoveQuestionPaper() {
        QuestionPaper questionPaper = new QuestionPaper("Что?", "Оно");
        QuestionPaper expected = new QuestionPaper("Что?", "Оно");
        QuestionPaper actual = javaQuestionPaperService.add(questionPaper);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCorrectlyThrowQuestionPaperAbsentErrorWhenRemovingNonExistentQuestionPaper () {
        QuestionPaper nonExistent = new QuestionPaper("Кто?", "Он");
        javaQuestionPaperService.add("Что?", "Оно");
        Assertions.assertThrows(QuestionPaperAbsent.class, () -> {
            javaQuestionPaperService.remove(nonExistent);
        });
    }

    @Test
    void getAll() {
        Collection<QuestionPaper> expected = new ArrayList<>();
        QuestionPaper questionPaper1 = new QuestionPaper("Что?", "Оно");
        QuestionPaper questionPaper2 = new QuestionPaper("Где?", "Там");
        QuestionPaper questionPaper3 = new QuestionPaper("Когда?", "Тогда");
        expected.add(questionPaper1);
        expected.add(questionPaper2);
        expected.add(questionPaper3);
        javaQuestionPaperService.add("Что?", "Оно");
        javaQuestionPaperService.add("Где?", "Там");
        javaQuestionPaperService.add("Когда?", "Тогда");
        Collection<QuestionPaper> actual = javaQuestionPaperService.getAll();
        Assertions.assertEquals(expected, actual);
    }

}