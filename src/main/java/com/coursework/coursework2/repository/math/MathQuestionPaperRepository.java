package com.coursework.coursework2.repository.math;

import com.coursework.coursework2.model.math.MathQuestionPaper;

import java.util.ArrayList;

public interface MathQuestionPaperRepository {
    MathQuestionPaper add(MathQuestionPaper mathQuestionPaper);
    MathQuestionPaper remove(MathQuestionPaper mathQuestionPaper);
    ArrayList<MathQuestionPaper> getAll();
}
