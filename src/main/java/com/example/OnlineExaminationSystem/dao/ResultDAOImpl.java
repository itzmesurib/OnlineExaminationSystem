package com.example.OnlineExaminationSystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.OnlineExaminationSystem.entity.Result;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ResultDAOImpl implements ResultDAO {

    @Autowired
    private SessionFactory sessionFactory; // Inject SessionFactory

    @Override
    public Result saveResult(Result result) {
        Session session = sessionFactory.getCurrentSession(); // Get current session
        session.persist(result); // Use Session to persist
        return result;
    }

    @Override
    public Result getResultById(Long id) {
        Session session = sessionFactory.getCurrentSession(); // Get current session
        return session.get(Result.class, id); // Use Session to get result by ID
    }

    @Override
    public List<Result> getAllResults() {
        Session session = sessionFactory.getCurrentSession(); // Get current session
        return session.createQuery("FROM Result", Result.class).getResultList(); // Use Session to create query
    }

    @Override
    public void updateResult(Long id, Result result) {
        Session session = sessionFactory.getCurrentSession(); // Get current session
        Result existingResult = session.get(Result.class, id); // Use Session to find existing result
        if (existingResult != null) {
            existingResult.setTotalMarks(result.getTotalMarks());
            existingResult.setGettingMarks(result.getGettingMarks());
            existingResult.setStudentId(result.getStudentId());
            existingResult.setQuestionPaperId(result.getQuestionPaperId());
            session.update(existingResult); // Use Session to update
        }
    }

    @Override
    public void deleteResult(Long id) {
        Session session = sessionFactory.getCurrentSession(); // Get current session
        Result result = session.get(Result.class, id); // Use Session to find result
        if (result != null) {
            session.delete(result); // Use Session to delete
        }
    }
}
