package com.coursework.coursework2.repository.java.impl;

import com.coursework.coursework2.error.EntityAlreadyPresent;
import com.coursework.coursework2.error.QuestionPaperAbsent;
import com.coursework.coursework2.error.SameEntitiesGiven;
import com.coursework.coursework2.model.java.JavaQuestionPaper;
import com.coursework.coursework2.repository.java.JavaQuestionPaperRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Component
public class JavaQuestionPaperRepositoryImpl implements JavaQuestionPaperRepository {

    private final ArrayList<JavaQuestionPaper> javaQuestionPapers = new ArrayList<>();

    @PostConstruct
    public void init() {
        javaQuestionPapers.add(new JavaQuestionPaper("What?", "That"));
        javaQuestionPapers.add(new JavaQuestionPaper("Where?", "There"));
        javaQuestionPapers.add(new JavaQuestionPaper("When?", "Then"));
    }

    @Override
    public JavaQuestionPaper add(JavaQuestionPaper javaQuestionPaper) {

        javaQuestionPapers.add(javaQuestionPaper);
        return javaQuestionPaper;

    }

    @Override
    public JavaQuestionPaper remove(JavaQuestionPaper javaQuestionPaper) {

        if(!javaQuestionPapers.contains(javaQuestionPaper)) {
            throw new QuestionPaperAbsent("Билет отсутствует");
        }

        javaQuestionPapers.remove(javaQuestionPaper);
        return javaQuestionPaper;

    }

    @Override
    public ArrayList<JavaQuestionPaper> getAll() {
        return javaQuestionPapers;
    };


}
