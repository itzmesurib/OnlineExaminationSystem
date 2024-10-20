package com.example.OnlineExaminationSystem.service;


import com.example.OnlineExaminationSystem.entity.QuestionPaper;

import java.util.List;

public interface QuestionPaperService {
    QuestionPaper saveQuestionPaper(QuestionPaper questionPaper);   // Create new question paper
    QuestionPaper getQuestionPaperById(Long id);                    // Get question paper by ID
    List<QuestionPaper> getAllQuestionPapers();                     // Get all question papers
    List<QuestionPaper> getQuestionPapersByAdminId(Long adminId);   // Get question papers by admin
    QuestionPaper updateQuestionPaper(Long id, QuestionPaper questionPaper); // Update question paper details
    void deleteQuestionPaper(Long id);                              // Delete question paper by ID
}
