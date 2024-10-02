package com.example.OnlineExaminationSystem.repository;

import org.springframework.stereotype.Repository;

import com.example.OnlineExaminationSystem.entity.Admin;

@Repository
public interface AdminRepository{
    Admin findByEmail(String email);
}
