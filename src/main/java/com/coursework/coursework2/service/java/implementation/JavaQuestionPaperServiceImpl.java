package com.coursework.coursework2.service.java.implementation;

import com.coursework.coursework2.error.EntityAlreadyPresent;
import com.coursework.coursework2.error.SameEntitiesGiven;
import com.coursework.coursework2.model.java.JavaQuestionPaper;
import com.coursework.coursework2.repository.java.JavaQuestionPaperRepository;
import com.coursework.coursework2.service.java.JavaQuestionPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionPaperServiceImpl implements JavaQuestionPaperService {

    private final JavaQuestionPaperRepository javaQuestionPaperRepository;

    public JavaQuestionPaperServiceImpl(JavaQuestionPaperRepository javaQuestionPaperRepository) {
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
    public JavaQuestionPaper add(String question, String answer) {

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
    public JavaQuestionPaper remove(String question, String answer) {

        JavaQuestionPaper javaQuestionPaper = new JavaQuestionPaper(question, answer);
        return javaQuestionPaperRepository.remove(javaQuestionPaper);

    }

    @Override
    public ArrayList<JavaQuestionPaper> getAll() {
        return javaQuestionPaperRepository.getAll();
    }

    @Override
    public JavaQuestionPaper getRandomQuestionPaper() {
        Random random = new Random();
        Integer javaQuestionPaperId = random.nextInt(javaQuestionPaperRepository.getAll().size());
        return javaQuestionPaperRepository.getAll().get(javaQuestionPaperId);
    };


}
