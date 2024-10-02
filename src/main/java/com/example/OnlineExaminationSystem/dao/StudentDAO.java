package com.example.OnlineExaminationSystem.dao;

import com.example.OnlineExaminationSystem.entity.Student;

import java.util.List;

public interface StudentDAO {
    Student saveStudent(Student student);
    Student getStudentById(Long id);
    List<Student> getAllStudents();
    void updateStudent(Long id, Student student);
    void deleteStudent(Long id);
}
