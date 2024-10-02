package com.example.OnlineExaminationSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.OnlineExaminationSystem.entity.Question;
import com.example.OnlineExaminationSystem.repository.QuestionRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
@Transactional
public class QuestionService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Question getQuestionById(Long id) {
        return entityManager.find(Question.class, id);
    }

    public Question saveQuestion(Question question) {
        entityManager.persist(question);
        return question;
    }

    public void deleteQuestion(Long id) {
        Question question = entityManager.find(Question.class, id);
        if (question != null) {
            entityManager.remove(question);
        }
    }
    
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }
}
