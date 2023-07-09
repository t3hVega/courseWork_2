package com.coursework.coursework2.repository.java;

import com.coursework.coursework2.model.java.JavaQuestionPaper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface JavaQuestionPaperRepository {
    JavaQuestionPaper add(JavaQuestionPaper javaQuestionPaper);
    JavaQuestionPaper remove(JavaQuestionPaper javaQuestionPaper);
    ArrayList<JavaQuestionPaper> getAll();
}
