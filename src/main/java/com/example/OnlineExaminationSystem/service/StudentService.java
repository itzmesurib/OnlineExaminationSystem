package com.example.OnlineExaminationSystem.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.OnlineExaminationSystem.entity.Student;
import com.example.OnlineExaminationSystem.repository.StudentRepository;

@Service
@Transactional
public class StudentService {

    private final SessionFactory sessionFactory;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


    public Student getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student saveStudent(Student student) {
        getCurrentSession().persist(student); // Using SessionFactory to persist
        return student;
    }

    public void deleteStudent(Long id) {
        Student student = getCurrentSession().get(Student.class, id); // Find the student by ID
        if (student != null) {
            getCurrentSession().remove(student); // Remove using Session
        }
    }

    public Student registerStudent(Student student) {
        // Validate student details if needed
        if (student.getEmail() == null || student.getPassword() == null) {
            throw new IllegalArgumentException("Email and Password are required fields.");
        }

        getCurrentSession().persist(student); // Persist the student
        return student;
    }

    public Student updateStudent(Long studentId, Student student) {
        // Find the existing student by ID
        Student existingStudent = getCurrentSession().get(Student.class, studentId);
        if (existingStudent == null) {
            throw new RuntimeException("Student not found with ID: " + studentId);
        }

        // Update the existing student's details
        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setPassword(student.getPassword());
        // Update any other fields as required

        // Save the updated student to repository
        return (Student) getCurrentSession().merge(existingStudent); // Use merge to update
    }
}
