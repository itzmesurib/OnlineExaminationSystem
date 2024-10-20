package com.example.OnlineExaminationSystem.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OnlineExaminationSystem.entity.QuestionPaper;

@Repository
public interface QuestionPaperRepository extends JpaRepository<QuestionPaper, Long> {

    // Custom query to find all question papers created by a specific admin
    List<QuestionPaper> findByAdminId(Long adminId);
}

