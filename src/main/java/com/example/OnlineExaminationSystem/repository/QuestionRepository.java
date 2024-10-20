package com.example.OnlineExaminationSystem.repository;


import com.example.OnlineExaminationSystem.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    // Custom query to find all questions by question paper ID
    List<Question> findByQuestionPaperId(Long questionPaperId);
}
