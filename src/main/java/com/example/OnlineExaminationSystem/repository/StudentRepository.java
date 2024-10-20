package com.example.OnlineExaminationSystem.repository;


import com.example.OnlineExaminationSystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Custom query to find student by username
    Student findByUsername(String username);
}
