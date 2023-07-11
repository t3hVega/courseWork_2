package com.coursework.coursework2.service.questionPaper;


import com.coursework.coursework2.error.EntityAlreadyPresent;
import com.coursework.coursework2.model.base.QuestionPaper;
import com.coursework.coursework2.model.math.MathQuestionPaper;
import com.coursework.coursework2.repository.MathQuestionPaperRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;

@Component
@Qualifier("math")
public class MathQuestionPaperService implements QuestionPaperService {
    private final MathQuestionPaperRepository mathQuestionPaperRepository;

    public MathQuestionPaperService(MathQuestionPaperRepository mathQuestionPaperRepository) {
        this.mathQuestionPaperRepository = mathQuestionPaperRepository;
    }


    public boolean isQuestionPresent(String word) {
        boolean isPresent = false;
        for (int i = 0; i < mathQuestionPaperRepository.getAll().size(); i++) {
            if (mathQuestionPaperRepository.getAll().get(i).getQuestion().equals(word)) {
                isPresent = true;
            };
        }
        return isPresent;

    }

    public boolean isAnswerPresent(Integer number) {
        boolean isPresent = false;
        for (int i = 0; i < mathQuestionPaperRepository.getAll().size(); i++) {
            if (mathQuestionPaperRepository.getAll().get(i).getAnswer().equals(number)) {
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
        Integer answerInt = Integer.parseInt(answer);
        MathQuestionPaper mathQuestionPaper = new MathQuestionPaper(question, answerInt);
        return mathQuestionPaperRepository.add(mathQuestionPaper);
    }

    @Override
    public QuestionPaper remove(String question, String answer) {
        Integer answerInt = Integer.parseInt(answer);
        MathQuestionPaper mathQuestionPaper = new MathQuestionPaper(question, answerInt);
        return mathQuestionPaperRepository.remove(mathQuestionPaper);
    }

    @Override
    public ArrayList<QuestionPaper> getAll() {
        return mathQuestionPaperRepository.getAll();
    }

    @Override
    public QuestionPaper getRandomQuestionPaper() {
        Random random = new Random();
        Integer questionPaperId = random.nextInt(mathQuestionPaperRepository.getAll().size());
        return mathQuestionPaperRepository.getAll().get(questionPaperId);
    }
}
