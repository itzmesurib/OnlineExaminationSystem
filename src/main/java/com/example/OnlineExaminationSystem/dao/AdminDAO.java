package com.example.OnlineExaminationSystem.dao;

import com.example.OnlineExaminationSystem.entity.Admin;

import java.util.List;

public interface AdminDAO {
    Admin saveAdmin(Admin admin);
    Admin getAdminById(Long id);
    List<Admin> getAllAdmins();
    void updateAdmin(Long id, Admin admin);
    void deleteAdmin(Long id);
}
