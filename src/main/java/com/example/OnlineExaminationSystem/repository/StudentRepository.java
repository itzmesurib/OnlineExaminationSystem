package com.example.OnlineExaminationSystem.repository;

import org.springframework.stereotype.Repository;

import com.example.OnlineExaminationSystem.entity.Student;

@Repository
public interface StudentRepository {
    Student findByEmail(String email);
    void save(Student student);
    void delete(Long id);
    Student findById(Long id);
}
