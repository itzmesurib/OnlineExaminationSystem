package com.example.OnlineExaminationSystem.service.impl;

import com.example.OnlineExaminationSystem.entity.QuestionPaper;
import com.example.OnlineExaminationSystem.repository.QuestionPaperRepository;
import com.example.OnlineExaminationSystem.service.QuestionPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionPaperServiceImpl implements QuestionPaperService {

    @Autowired
    private QuestionPaperRepository questionPaperRepository;

    @Override
    public QuestionPaper saveQuestionPaper(QuestionPaper questionPaper) {
        return questionPaperRepository.save(questionPaper);
    }

    @Override
    public QuestionPaper getQuestionPaperById(Long id) {
        return questionPaperRepository.findById(id).orElseThrow(() -> new RuntimeException("Question Paper not found"));
    }

    @Override
    public List<QuestionPaper> getAllQuestionPapers() {
        return questionPaperRepository.findAll();
    }

    @Override
    public List<QuestionPaper> getQuestionPapersByAdminId(Long adminId) {
        return questionPaperRepository.findByAdminId(adminId);
    }

    @Override
    public QuestionPaper updateQuestionPaper(Long id, QuestionPaper questionPaper) {
        QuestionPaper existingQuestionPaper = getQuestionPaperById(id);
        existingQuestionPaper.setTitle(questionPaper.getTitle());
        return questionPaperRepository.save(existingQuestionPaper);
    }

    @Override
    public void deleteQuestionPaper(Long id) {
        questionPaperRepository.deleteById(id);
    }
}

