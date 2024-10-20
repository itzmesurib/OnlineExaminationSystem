package com.example.OnlineExaminationSystem.service;


import com.example.OnlineExaminationSystem.entity.Result;

import java.util.List;

public interface ResultService {
    Result saveResult(Result result);                   // Create new result
    Result getResultById(Long id);                      // Get result by ID
    List<Result> getResultsByStudentId(Long studentId); // Get all results for a student
    Result getResultByStudentAndQuestionPaper(Long studentId, Long questionPaperId); // Get result by student and question paper
    void deleteResult(Long id);                         // Delete result by ID
}
