package com.example.OnlineExaminationSystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.OnlineExaminationSystem.entity.Question;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class QuestionDAOImpl implements QuestionDAO {

    @Autowired
    private SessionFactory sessionFactory; // Inject SessionFactory

    @Override
    public Question saveQuestion(Question question) {
        Session session = sessionFactory.getCurrentSession(); // Get current session
        session.persist(question); // Use Session to persist
        return question;
    }

    @Override
    public Question getQuestionById(Long id) {
        Session session = sessionFactory.getCurrentSession(); // Get current session
        return session.get(Question.class, id); // Use Session to get question by ID
    }

    @Override
    public List<Question> getAllQuestions() {
        Session session = sessionFactory.getCurrentSession(); // Get current session
        return session.createQuery("FROM Question", Question.class).getResultList(); // Use Session to create query
    }

    @Override
    public void updateQuestion(Long id, Question question) {
        Session session = sessionFactory.getCurrentSession(); // Get current session
        Question existingQuestion = session.get(Question.class, id); // Use Session to find existing question
        if (existingQuestion != null) {
            existingQuestion.setQuestionText(question.getQuestionText());
            existingQuestion.setOption1(question.getOption1());
            existingQuestion.setOption2(question.getOption2());
            existingQuestion.setOption3(question.getOption3());
            existingQuestion.setOption4(question.getOption4());
            existingQuestion.setCorrectOption(question.getCorrectOption());
            session.update(existingQuestion); // Use Session to update
        }
    }

    @Override
    public void deleteQuestion(Long id) {
        Session session = sessionFactory.getCurrentSession(); // Get current session
        Question question = session.get(Question.class, id); // Use Session to find question
        if (question != null) {
            session.delete(question); // Use Session to delete
        }
    }
}
