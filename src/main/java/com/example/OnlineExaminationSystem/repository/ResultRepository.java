package com.example.OnlineExaminationSystem.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.OnlineExaminationSystem.entity.Result;

@Repository
public interface ResultRepository {
    List<Result> findByStudentId(Long studentId);
    List<Result> findByQuestionPaperId(Long questionPaperId);
    void save(Result result);
    void delete(Long id);
    Result findById(Long id);
}
