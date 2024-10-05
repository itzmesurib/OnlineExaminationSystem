package com.example.OnlineExaminationSystem.controller;

import com.example.OnlineExaminationSystem.entity.Question;
import com.example.OnlineExaminationSystem.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/add")
    public String addQuestion(@RequestBody Question question) {
        questionService.addQuestion(question);
        return "Question added successfully!";
    }

//    @GetMapping("/all")
//    public List<Question> getAllQuestions() {
//        return questionService.getAllQuestions();
//    }

//    @PutMapping("/update")
//    public String updateQuestion(@RequestBody Question question) {
//        questionService.updateQuestion(question);
//        return "Question updated successfully!";
//    }

//    @DeleteMapping("/delete/{id}")
//    public String deleteQuestion(@PathVariable Long id) {
//        questionService.deleteQuestion(id);
//        return "Question deleted successfully!";
//    }
}
