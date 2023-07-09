package com.coursework.coursework2.service.math;


import com.coursework.coursework2.model.math.MathQuestionPaper;

import java.util.ArrayList;

public interface MathQuestionPaperService {
    MathQuestionPaper add(String question, Integer answer);
    MathQuestionPaper remove(String question, Integer answer);
    ArrayList<MathQuestionPaper> getAll();
    MathQuestionPaper getRandomQuestionPaper();
}
