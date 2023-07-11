package com.coursework.coursework2.service.questionPaper;

import com.coursework.coursework2.error.EntityAlreadyPresent;
import com.coursework.coursework2.error.SameEntitiesGiven;
import com.coursework.coursework2.model.base.QuestionPaper;
import com.coursework.coursework2.model.java.JavaQuestionPaper;
import com.coursework.coursework2.repository.QuestionPaperRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;

@Component
@Qualifier("java")
public class JavaQuestionPaperService implements QuestionPaperService {

    private final QuestionPaperRepository javaQuestionPaperRepository;

    public JavaQuestionPaperService(QuestionPaperRepository javaQuestionPaperRepository) {
        this.javaQuestionPaperRepository = javaQuestionPaperRepository;
    }

    public boolean isQuestionPresent(String word) {
        boolean isPresent = false;
        for (int i = 0; i < javaQuestionPaperRepository.getAll().size(); i++) {
            if (javaQuestionPaperRepository.getAll().get(i).getQuestion().equals(word)) {
                isPresent = true;
            };
        }

        return isPresent;
    }

    public boolean isAnswerPresent(String word) {
        boolean isPresent = false;
        for (int i = 0; i < javaQuestionPaperRepository.getAll().size(); i++) {
            if (javaQuestionPaperRepository.getAll().get(i).getAnswer().equals(word)) {
                isPresent = true;
            };
        }
        return isPresent;
    }

    @Override
    public QuestionPaper add(String question, String answer) {

        if (isQuestionPresent(question) == true) {
            throw new EntityAlreadyPresent("Данный вопрос уже присутствует");
        }

        if (isAnswerPresent(answer) == true) {
            throw new EntityAlreadyPresent("Данный ответ уже присутствует");
        }

        if (question.equals(answer)) {
            throw new SameEntitiesGiven("Вопрос и ответ совпадают");
        }

        JavaQuestionPaper javaQuestionPaper = new JavaQuestionPaper(question, answer);
        return javaQuestionPaperRepository.add(javaQuestionPaper);

    }

    @Override
    public QuestionPaper remove(String question, String answer) {

        JavaQuestionPaper javaQuestionPaper = new JavaQuestionPaper(question, answer);
        return javaQuestionPaperRepository.remove(javaQuestionPaper);

    }

    @Override
    public ArrayList<QuestionPaper> getAll() {
        return javaQuestionPaperRepository.getAll();
    }

    @Override
    public QuestionPaper getRandomQuestionPaper() {
        Random random = new Random();
        Integer javaQuestionPaperId = random.nextInt(javaQuestionPaperRepository.getAll().size());
        return javaQuestionPaperRepository.getAll().get(javaQuestionPaperId);
    };
}
