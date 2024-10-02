package com.example.OnlineExaminationSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OnlineExaminationSystem.entity.Result;
import com.example.OnlineExaminationSystem.repository.ResultRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


@Service
@Transactional
public class ResultService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ResultRepository resultRepository;

    // Add a new result
    public Result addResult(Result result) {
        entityManager.persist(result);
        return result;
    }

    // Get results by student ID
    public List<Result> getResultsByStudent(Long studentId) {
        return resultRepository.findByStudentId(studentId);
    }

    // Update an existing result
    public Result updateResult(Long id, Result result) {
        Optional<Result> existingResultOptional = resultRepository.findById(id);
        if (existingResultOptional.isPresent()) {
            Result existingResult = existingResultOptional.get();
            // Update fields as necessary
            existingResult.setScore(result.getScore());
            existingResult.setTotalMarks(result.getTotalMarks());
            existingResult.setExamId(result.getExamId()); // Assuming there is a relation to the Exam entity
            
            return entityManager.merge(existingResult); // Use merge for updating the entity
        }
        return null; // Return null if the result does not exist
    }

    public void deleteResult(Long resultId) {
        Result result = entityManager.find(Result.class, resultId);
        if (result != null) {
            entityManager.remove(result);
        }
    }
}
