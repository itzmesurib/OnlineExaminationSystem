package com.example.OnlineExaminationSystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.OnlineExaminationSystem.entity.Result;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ResultDAOImpl implements ResultDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public Result saveResult(Result result) {
        entityManager.persist(result);
        return result;
    }

    @Override
    public Result getResultById(Long id) {
        return entityManager.find(Result.class, id);
    }

    @Override
    public List<Result> getAllResults() {
        return entityManager.createQuery("FROM Result", Result.class).getResultList();
    }

    @Override
    public void updateResult(Long id, Result result) {
        Result existingResult = entityManager.find(Result.class, id);
        if (existingResult != null) {
            existingResult.setTotalMarks(result.getTotalMarks());
            existingResult.setGettingMarks(result.getGettingMarks());
            existingResult.setStudentId(result.getStudentId());
            existingResult.setQuestionPaperId(result.getQuestionPaperId());
            entityManager.merge(existingResult);
        }
    }

    @Override
    public void deleteResult(Long id) {
        Result result = entityManager.find(Result.class, id);
        if (result != null) {
            entityManager.remove(result);
        }
    }
}
