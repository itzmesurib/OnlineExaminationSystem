package com.example.OnlineExaminationSystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.OnlineExaminationSystem.entity.Student;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private SessionFactory sessionFactory; // Inject SessionFactory

    @Override
    public Student saveStudent(Student student) {
        Session session = sessionFactory.getCurrentSession(); // Get current session
        session.persist(student); // Use Session to persist
        return student;
    }

    @Override
    public Student getStudentById(Long id) {
        Session session = sessionFactory.getCurrentSession(); // Get current session
        return session.get(Student.class, id); // Use Session to get student by ID
    }

    @Override
    public List<Student> getAllStudents() {
        Session session = sessionFactory.getCurrentSession(); // Get current session
        return session.createQuery("FROM Student", Student.class).getResultList(); // Use Session to create query
    }

    @Override
    public void updateStudent(Long id, Student student) {
        Session session = sessionFactory.getCurrentSession(); // Get current session
        Student existingStudent = session.get(Student.class, id); // Use Session to find existing student
        if (existingStudent != null) {
            existingStudent.setName(student.getName());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setPassword(student.getPassword());
            existingStudent.setPhoneNumber(student.getPhoneNumber());
            existingStudent.setQualification(student.getQualification());
            session.update(existingStudent); // Use Session to update
        }
    }

    @Override
    public void deleteStudent(Long id) {
        Session session = sessionFactory.getCurrentSession(); // Get current session
        Student student = session.get(Student.class, id); // Use Session to find student
        if (student != null) {
            session.delete(student); // Use Session to delete
        }
    }
}
