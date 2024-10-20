package com.example.OnlineExaminationSystem.controller;


import com.example.OnlineExaminationSystem.entity.Result;
import com.example.OnlineExaminationSystem.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/results")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @PostMapping
    public ResponseEntity<Result> createResult(@RequestBody Result result) {
        Result savedResult = resultService.saveResult(result);
        return ResponseEntity.ok(savedResult);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Result> getResultById(@PathVariable Long id) {
        Result result = resultService.getResultById(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Result>> getResultsByStudentId(@PathVariable Long studentId) {
        List<Result> results = resultService.getResultsByStudentId(studentId);
        return ResponseEntity.ok(results);
    }

    @GetMapping("/student/{studentId}/question-paper/{questionPaperId}")
    public ResponseEntity<Result> getResultByStudentAndQuestionPaper(@PathVariable Long studentId, @PathVariable Long questionPaperId) {
        Result result = resultService.getResultByStudentAndQuestionPaper(studentId, questionPaperId);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResult(@PathVariable Long id) {
        resultService.deleteResult(id);
        return ResponseEntity.noContent().build();
    }
}
