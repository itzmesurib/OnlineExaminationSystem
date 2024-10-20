package com.example.OnlineExaminationSystem.service.impl;

import com.example.OnlineExaminationSystem.entity.Student;
import com.example.OnlineExaminationSystem.repository.StudentRepository;
import com.example.OnlineExaminationSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student existingStudent = getStudentById(id);
        existingStudent.setUsername(student.getUsername());
        existingStudent.setPassword(student.getPassword());
        existingStudent.setName(student.getName());
        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student findByUsername(String username) {
        return studentRepository.findByUsername(username);
    }
}
