package com.example.OnlineExaminationSystem.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.OnlineExaminationSystem.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class StudentDAOImpl implements StudentDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Student saveStudent(Student student) {
        entityManager.persist(student);
        return student;
    }

    @Override
    public Student getStudentById(Long id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> getAllStudents() {
        return entityManager.createQuery("FROM Student", Student.class).getResultList();
    }

    @Override
    public void updateStudent(Long id, Student student) {
        Student existingStudent = entityManager.find(Student.class, id);
        if (existingStudent != null) {
            existingStudent.setName(student.getName());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setPassword(student.getPassword());
            existingStudent.setPhoneNumber(student.getPhoneNumber());
            existingStudent.setQualification(student.getQualification());
            entityManager.merge(existingStudent);
        }
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = entityManager.find(Student.class, id);
        if (student != null) {
            entityManager.remove(student);
        }
    }
}
