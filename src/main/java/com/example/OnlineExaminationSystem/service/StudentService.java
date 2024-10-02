package com.example.OnlineExaminationSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OnlineExaminationSystem.entity.Student;
import com.example.OnlineExaminationSystem.repository.StudentRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student saveStudent(Student student) {
        entityManager.persist(student); // Using EntityManager to persist
        return student;
    }

    public void deleteStudent(Long id) {
        Student student = entityManager.find(Student.class, id); // Find the student by ID
        if (student != null) {
            entityManager.remove(student); // Remove using EntityManager
        }
    }
    
    public Student registerStudent(Student student) {
        // Validate student details if needed
        if (student.getEmail() == null || student.getPassword() == null) {
            throw new IllegalArgumentException("Email and Password are required fields.");
        }

        entityManager.persist(student); // Persist the student
        
        return student;
    }
    
    public Student updateStudent(Long studentId, Student student) {
        // Find the existing student by ID
        Student existingStudent = entityManager.find(Student.class, studentId);
        if (existingStudent == null) {
            throw new RuntimeException("Student not found with ID: " + studentId);
        }

        // Update the existing student's details
        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setPassword(student.getPassword());
        // Update any other fields as required

        // Save the updated student to repository
        return entityManager.merge(existingStudent); // Use merge to update
    }
}
