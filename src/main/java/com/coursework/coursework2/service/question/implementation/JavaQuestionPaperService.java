package com.coursework.coursework2.service.question.implementation;

import com.coursework.coursework2.error.EntityAlreadyPresent;
import com.coursework.coursework2.error.QuestionPaperAbsent;
import com.coursework.coursework2.error.SameEntitiesGiven;
import com.coursework.coursework2.model.QuestionPaper;
import com.coursework.coursework2.service.question.QuestionPaperService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionPaperService implements QuestionPaperService {

    private ArrayList<QuestionPaper> questionPapers = new ArrayList<>();

    public boolean isQuestionPresent(String word) {
        boolean isPresent = false;
        for (int i = 0; i < questionPapers.size(); i++) {
            if (questionPapers.get(i).getQuestion().equals(word)) {
                isPresent = true;
            };
        }
        return isPresent;
    }

    public boolean isAnswerPresent(String word) {
        boolean isPresent = false;
        for (int i = 0; i < questionPapers.size(); i++) {
            if (questionPapers.get(i).getAnswer().equals(word)) {
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

        QuestionPaper questionPaper = new QuestionPaper(question, answer);
        questionPapers.add(questionPaper);
        return questionPaper;
    }

    @Override
    public QuestionPaper add(QuestionPaper questionPaper) {
        questionPapers.add(questionPaper);
        return questionPaper;
    }

    @Override
    public QuestionPaper remove(QuestionPaper questionPaper) {

        if(!questionPapers.contains(questionPaper)) {
            throw new QuestionPaperAbsent("Билет отсутствует");
        }

        questionPapers.remove(questionPaper);
        return questionPaper;
    }

    @Override
    public ArrayList<QuestionPaper> getAll() {
        return questionPapers;
    }


}
