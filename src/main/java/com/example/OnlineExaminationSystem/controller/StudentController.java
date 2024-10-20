package com.example.OnlineExaminationSystem.controller;


import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.OnlineExaminationSystem.entity.Student;
import com.example.OnlineExaminationSystem.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
    
    @GetMapping("/home")
    public String homePage() {
    	return "home";
    }
    
    @GetMapping("/register")
    public String showStudentRegisterPage() {
        return "student-register"; 
    }

    @PostMapping("/addStudent")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student savedStudent = studentService.saveStudent(student);
        return ResponseEntity.ok(savedStudent);
    }
    
    @GetMapping("/login")
    public String studentLogin() {
    	return "student-login";
    }
    
    @PostMapping("/loginStudent")
    public ResponseEntity<String> loginStudent(@RequestParam String username, @RequestParam String password) {
        Student student = studentService.findByUsername(username);

        if (student != null && student.getPassword().equals(password)) {
            return new ResponseEntity<>("Login successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
        }
    }
    
    @GetMapping("/dashboard")
    public String studentDashboard() {
    	return "dashboard";
    }
    
    @GetMapping("/data")
    public ResponseEntity<Student> getStudentData(Principal principal) {
        String username = principal.getName();
        // Fetch student data by username (typically stored in the database)
        Student student = studentService.findByUsername(username);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(id, student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-username/{username}")
    public ResponseEntity<Student> getStudentByUsername(@PathVariable String username) {
        Student student = studentService.findByUsername(username);
        return ResponseEntity.ok(student);
    }
}
