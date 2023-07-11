package com.coursework.coursework2.repository;

import com.coursework.coursework2.error.QuestionPaperAbsent;
import com.coursework.coursework2.model.base.QuestionPaper;
import com.coursework.coursework2.model.java.JavaQuestionPaper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Component
public class JavaQuestionPaperRepository implements QuestionPaperRepository {

    private final ArrayList<QuestionPaper> javaQuestionPapers = new ArrayList<>();

    @PostConstruct
    public void init() {
        javaQuestionPapers.add(new JavaQuestionPaper("What?", "That"));
        javaQuestionPapers.add(new JavaQuestionPaper("Where?", "There"));
        javaQuestionPapers.add(new JavaQuestionPaper("When?", "Then"));
    }

    @Override
    public QuestionPaper add(QuestionPaper javaQuestionPaper) {

        javaQuestionPapers.add(javaQuestionPaper);
        return javaQuestionPaper;

    }

    @Override
    public QuestionPaper remove(QuestionPaper javaQuestionPaper) {

        if(!javaQuestionPapers.contains(javaQuestionPaper)) {
            throw new QuestionPaperAbsent("Билет отсутствует");
        }

        javaQuestionPapers.remove(javaQuestionPaper);
        return javaQuestionPaper;

    }

    @Override
    public ArrayList<QuestionPaper> getAll() {
        return javaQuestionPapers;
    };


}
