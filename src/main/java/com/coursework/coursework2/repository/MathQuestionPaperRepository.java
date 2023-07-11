package com.coursework.coursework2.repository;

import com.coursework.coursework2.error.QuestionPaperAbsent;
import com.coursework.coursework2.model.base.QuestionPaper;
import com.coursework.coursework2.model.math.MathQuestionPaper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Component
public class MathQuestionPaperRepository implements QuestionPaperRepository {

    private final ArrayList<QuestionPaper> mathQuestionPapers = new ArrayList<>();

    @PostConstruct
    public void init() {

        mathQuestionPapers.add(new MathQuestionPaper("Square root of 625?", 25));
        mathQuestionPapers.add(new MathQuestionPaper("Fourth prime number?", 7));
        mathQuestionPapers.add(new MathQuestionPaper("Three cubed?", 27));

    }

    @Override
    public QuestionPaper add(QuestionPaper mathQuestionPaper) {

        mathQuestionPapers.add(mathQuestionPaper);

        return mathQuestionPaper;

    }

    @Override
    public QuestionPaper remove(QuestionPaper mathQuestionPaper) {

        if(!mathQuestionPapers.contains(mathQuestionPaper)) {
            throw new QuestionPaperAbsent("Билет отсутствует");
        }

        mathQuestionPapers.remove(mathQuestionPaper);
        return mathQuestionPaper;

    }

    @Override
    public ArrayList<QuestionPaper> getAll() {
        return mathQuestionPapers;
    }

}
