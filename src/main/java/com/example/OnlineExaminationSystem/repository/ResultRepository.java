package com.example.OnlineExaminationSystem.repository;


import com.example.OnlineExaminationSystem.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {

    // Custom query to find all results by student ID
    List<Result> findByStudentId(Long studentId);

    // Custom query to find result for a specific student and question paper
    Result findByStudentIdAndQuestionPaperId(Long studentId, Long questionPaperId);
}

