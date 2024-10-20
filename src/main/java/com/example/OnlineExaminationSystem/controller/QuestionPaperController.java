package com.example.OnlineExaminationSystem.controller;


import com.example.OnlineExaminationSystem.entity.QuestionPaper;
import com.example.OnlineExaminationSystem.service.QuestionPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/question-papers")
public class QuestionPaperController {

    @Autowired
    private QuestionPaperService questionPaperService;

    @PostMapping
    public ResponseEntity<QuestionPaper> createQuestionPaper(@RequestBody QuestionPaper questionPaper) {
        QuestionPaper savedQuestionPaper = questionPaperService.saveQuestionPaper(questionPaper);
        return ResponseEntity.ok(savedQuestionPaper);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionPaper> getQuestionPaperById(@PathVariable Long id) {
        QuestionPaper questionPaper = questionPaperService.getQuestionPaperById(id);
        return ResponseEntity.ok(questionPaper);
    }

    @GetMapping
    public ResponseEntity<List<QuestionPaper>> getAllQuestionPapers() {
        List<QuestionPaper> questionPapers = questionPaperService.getAllQuestionPapers();
        return ResponseEntity.ok(questionPapers);
    }

    @GetMapping("/admin/{adminId}")
    public ResponseEntity<List<QuestionPaper>> getQuestionPapersByAdminId(@PathVariable Long adminId) {
        List<QuestionPaper> questionPapers = questionPaperService.getQuestionPapersByAdminId(adminId);
        return ResponseEntity.ok(questionPapers);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuestionPaper> updateQuestionPaper(@PathVariable Long id, @RequestBody QuestionPaper questionPaper) {
        QuestionPaper updatedQuestionPaper = questionPaperService.updateQuestionPaper(id, questionPaper);
        return ResponseEntity.ok(updatedQuestionPaper);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestionPaper(@PathVariable Long id) {
        questionPaperService.deleteQuestionPaper(id);
        return ResponseEntity.noContent().build();
    }
}
