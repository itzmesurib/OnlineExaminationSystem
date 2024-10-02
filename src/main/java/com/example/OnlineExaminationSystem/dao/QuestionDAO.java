package com.example.OnlineExaminationSystem.dao;

import com.example.OnlineExaminationSystem.entity.Question;

import java.util.List;

public interface QuestionDAO {
    Question saveQuestion(Question question);
    Question getQuestionById(Long id);
    List<Question> getAllQuestions();
    void updateQuestion(Long id, Question question);
    void deleteQuestion(Long id);
}
