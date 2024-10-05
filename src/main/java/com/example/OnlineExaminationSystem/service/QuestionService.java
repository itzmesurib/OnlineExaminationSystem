package com.example.OnlineExaminationSystem.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.OnlineExaminationSystem.entity.Question;
import com.example.OnlineExaminationSystem.repository.QuestionRepository;

@Service
@Transactional
public class QuestionService {

    private final SessionFactory sessionFactory;
    
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    public QuestionService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public Question getQuestionById(Long id) {
        return questionRepository.findById(id);
    }

    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }


}
