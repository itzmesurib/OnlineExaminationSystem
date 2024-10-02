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

    @PostMapping("/add")
    public String addResult(@RequestBody Result result) {
        resultService.addResult(result);
        return "Result added successfully!";
    }

    @GetMapping("/student/{studentId}")
    public List<Result> getResultsByStudent(@PathVariable Long studentId) {
        return resultService.getResultsByStudent(studentId);
    }

    @PutMapping("/update/{resultId}")
    public ResponseEntity<String> updateResult(@PathVariable Long resultId, @RequestBody Result result) {
        resultService.updateResult(resultId, result);
        return ResponseEntity.ok("Result updated successfully.");
    }

    @DeleteMapping("/delete/{id}")
    public String deleteResult(@PathVariable Long id) {
        resultService.deleteResult(id);
        return "Result deleted successfully!";
    }
}
