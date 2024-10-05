package com.example.OnlineExaminationSystem.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.OnlineExaminationSystem.entity.Question;

@Repository
public interface QuestionRepository {
    List<Question> findByQuestionPaperId(Long questionPaperId);
    Question save(Question question);
    void delete(Long id);
    Question findById(Long id);
}
