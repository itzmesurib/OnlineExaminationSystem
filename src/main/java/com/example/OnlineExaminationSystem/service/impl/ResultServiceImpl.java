package com.example.OnlineExaminationSystem.service.impl;


import com.example.OnlineExaminationSystem.entity.Result;
import com.example.OnlineExaminationSystem.repository.ResultRepository;
import com.example.OnlineExaminationSystem.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    private ResultRepository resultRepository;

    @Override
    public Result saveResult(Result result) {
        return resultRepository.save(result);
    }

    @Override
    public Result getResultById(Long id) {
        return resultRepository.findById(id).orElseThrow(() -> new RuntimeException("Result not found"));
    }

    @Override
    public List<Result> getResultsByStudentId(Long studentId) {
        return resultRepository.findByStudentId(studentId);
    }

    @Override
    public Result getResultByStudentAndQuestionPaper(Long studentId, Long questionPaperId) {
        return resultRepository.findByStudentIdAndQuestionPaperId(studentId, questionPaperId);
    }

    @Override
    public void deleteResult(Long id) {
        resultRepository.deleteById(id);
    }
}
