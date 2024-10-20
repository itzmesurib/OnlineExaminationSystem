package com.example.OnlineExaminationSystem.service;


import com.example.OnlineExaminationSystem.entity.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);          // Create new student
    Student getStudentById(Long id);               // Get student by ID
    List<Student> getAllStudents();                // Get all students
    Student updateStudent(Long id, Student student); // Update student details
    void deleteStudent(Long id);                   // Delete student by ID
    Student findByUsername(String username);       // Find student by username
}
