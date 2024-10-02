package com.example.OnlineExaminationSystem.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.OnlineExaminationSystem.entity.Question;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class QuestionDAOImpl implements QuestionDAO {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Question saveQuestion(Question question) {
        entityManager.persist(question);
        return question;
    }

    @Override
    public Question getQuestionById(Long id) {
        return entityManager.find(Question.class, id);
    }

    @Override
    public List<Question> getAllQuestions() {
        return entityManager.createQuery("FROM Question", Question.class).getResultList();
    }

    @Override
    public void updateQuestion(Long id, Question question) {
        Question existingQuestion = entityManager.find(Question.class, id);
        if (existingQuestion != null) {
            existingQuestion.setQuestionText(question.getQuestionText());
            existingQuestion.setOption1(question.getOption1());
            existingQuestion.setOption2(question.getOption2());
            existingQuestion.setOption3(question.getOption3());
            existingQuestion.setOption4(question.getOption4());
            existingQuestion.setCorrectOption(question.getCorrectOption());
            entityManager.merge(existingQuestion);
        }
    }

    @Override
    public void deleteQuestion(Long id) {
        Question question = entityManager.find(Question.class, id);
        if (question != null) {
            entityManager.remove(question);
        }
    }
}
