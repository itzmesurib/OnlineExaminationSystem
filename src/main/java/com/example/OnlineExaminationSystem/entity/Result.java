package com.example.OnlineExaminationSystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId; // Assuming you have a reference to the student
    private Long examId;    // Assuming you have a reference to the exam
    private Double score;    // The score the student received
    private Double totalMarks; // The total marks for the exam

    // Additional fields
    private Double gettingMarks; // Assuming this is a calculated field
    private Long questionPaperId; // Assuming this links to a question paper

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Double getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(Double totalMarks) {
        this.totalMarks = totalMarks;
    }

    public Double getGettingMarks() {
        return gettingMarks;
    }

    public void setGettingMarks(Double gettingMarks) {
        this.gettingMarks = gettingMarks;
    }

    public Long getQuestionPaperId() {
        return questionPaperId;
    }

    public void setQuestionPaperId(Long questionPaperId) {
        this.questionPaperId = questionPaperId;
    }
}
