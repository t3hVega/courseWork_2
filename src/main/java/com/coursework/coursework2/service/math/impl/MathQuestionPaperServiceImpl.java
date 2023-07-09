package com.coursework.coursework2.service.math.impl;

import com.coursework.coursework2.error.EntityAlreadyPresent;
import com.coursework.coursework2.error.SameEntitiesGiven;
import com.coursework.coursework2.model.math.MathQuestionPaper;
import com.coursework.coursework2.repository.math.MathQuestionPaperRepository;
import com.coursework.coursework2.service.math.MathQuestionPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class MathQuestionPaperServiceImpl implements MathQuestionPaperService {

    private final MathQuestionPaperRepository mathQuestionPaperRepository;

    public MathQuestionPaperServiceImpl(MathQuestionPaperRepository mathQuestionPaperRepository) {
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
    public MathQuestionPaper add(String question, Integer answer) {
        if (isQuestionPresent(question) == true) {
            throw new EntityAlreadyPresent("Данный вопрос уже присутствует");
        }

        MathQuestionPaper mathQuestionPaper = new MathQuestionPaper(question, answer);
        return mathQuestionPaperRepository.add(mathQuestionPaper);
    }

    @Override
    public MathQuestionPaper remove(String question, Integer answer) {
        MathQuestionPaper mathQuestionPaper = new MathQuestionPaper(question, answer);
        return mathQuestionPaperRepository.remove(mathQuestionPaper);
    }

    @Override
    public ArrayList<MathQuestionPaper> getAll() {
        return mathQuestionPaperRepository.getAll();
    }

    @Override
    public MathQuestionPaper getRandomQuestionPaper() {
        Random random = new Random();
        Integer questionPaperId = random.nextInt(mathQuestionPaperRepository.getAll().size());
        return mathQuestionPaperRepository.getAll().get(questionPaperId);
    }
}
