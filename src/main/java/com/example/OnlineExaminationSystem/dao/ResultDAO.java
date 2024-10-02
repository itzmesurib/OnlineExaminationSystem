package com.example.OnlineExaminationSystem.dao;

import com.example.OnlineExaminationSystem.entity.Result;

import java.util.List;

public interface ResultDAO {
    Result saveResult(Result result);
    Result getResultById(Long id);
    List<Result> getAllResults();
    void updateResult(Long id, Result result);
    void deleteResult(Long id);
}
