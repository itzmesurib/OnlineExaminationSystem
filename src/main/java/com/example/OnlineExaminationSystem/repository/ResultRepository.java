package com.example.OnlineExaminationSystem.repository;

import com.example.OnlineExaminationSystem.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {
    List<Result> findByStudentId(Long studentId);
    List<Result> findByQuestionPaperId(Long questionPaperId);
}
