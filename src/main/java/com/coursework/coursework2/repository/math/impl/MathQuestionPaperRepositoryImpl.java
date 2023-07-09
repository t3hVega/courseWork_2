package com.coursework.coursework2.repository.math.impl;

import com.coursework.coursework2.error.EntityAlreadyPresent;
import com.coursework.coursework2.error.QuestionPaperAbsent;
import com.coursework.coursework2.error.SameEntitiesGiven;
import com.coursework.coursework2.model.java.JavaQuestionPaper;
import com.coursework.coursework2.model.math.MathQuestionPaper;
import com.coursework.coursework2.repository.math.MathQuestionPaperRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Random;

@Component
public class MathQuestionPaperRepositoryImpl implements MathQuestionPaperRepository {

    private final ArrayList<MathQuestionPaper> mathQuestionPapers = new ArrayList<>();

    @PostConstruct
    public void init() {

        mathQuestionPapers.add(new MathQuestionPaper("Square root of 625?", 25));
        mathQuestionPapers.add(new MathQuestionPaper("Fourth prime number?", 7));
        mathQuestionPapers.add(new MathQuestionPaper("Three cubed?", 27));

    }

    @Override
    public MathQuestionPaper add(MathQuestionPaper mathQuestionPaper) {

        mathQuestionPapers.add(mathQuestionPaper);
        return mathQuestionPaper;

    }

    @Override
    public MathQuestionPaper remove(MathQuestionPaper mathQuestionPaper) {

        if(!mathQuestionPapers.contains(mathQuestionPaper)) {
            throw new QuestionPaperAbsent("Билет отсутствует");
        }

        mathQuestionPapers.remove(mathQuestionPaper);
        return mathQuestionPaper;

    }

    @Override
    public ArrayList<MathQuestionPaper> getAll() {
        return mathQuestionPapers;
    }

}
