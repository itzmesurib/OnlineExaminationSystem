package com.example.OnlineExaminationSystem.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.OnlineExaminationSystem.entity.Result;
import com.example.OnlineExaminationSystem.repository.ResultRepository;

@Service
@Transactional
public class ResultService {

    private final SessionFactory sessionFactory;

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    public ResultService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    // Add a new result
    public Result addResult(Result result) {
        getCurrentSession().persist(result);
        return result;
    }

    // Get results by student ID
    public List<Result> getResultsByStudent(Long studentId) {
        return resultRepository.findByStudentId(studentId);
    }

    // Update an existing result
    public Result updateResult(Long id, Result result) {
        Optional<Result> existingResultOptional = Optional.of(resultRepository.findById(id));
        if (existingResultOptional.isPresent()) {
            Result existingResult = existingResultOptional.get();
            // Update fields as necessary
            existingResult.setScore(result.getScore());
            existingResult.setTotalMarks(result.getTotalMarks());
            existingResult.setExamId(result.getExamId()); // Assuming there is a relation to the Exam entity
            
            return (Result) getCurrentSession().merge(existingResult); // Use merge for updating the entity
        }
        return null; // Return null if the result does not exist
    }

    public void deleteResult(Long resultId) {
        Result result = getCurrentSession().get(Result.class, resultId);
        if (result != null) {
            getCurrentSession().remove(result);
        }
    }
}
