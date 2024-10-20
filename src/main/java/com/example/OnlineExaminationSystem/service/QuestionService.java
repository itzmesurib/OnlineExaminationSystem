package com.example.OnlineExaminationSystem.service;


import com.example.OnlineExaminationSystem.entity.Question;

import java.util.List;

public interface QuestionService {
    Question saveQuestion(Question question);           // Create new question
    Question getQuestionById(Long id);                  // Get question by ID
    List<Question> getQuestionsByQuestionPaperId(Long questionPaperId); // Get all questions for a question paper
    Question updateQuestion(Long id, Question question); // Update question details
    void deleteQuestion(Long id);                       // Delete question by ID
}
