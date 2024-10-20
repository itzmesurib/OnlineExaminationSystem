package com.example.OnlineExaminationSystem.service;


import com.example.OnlineExaminationSystem.entity.Admin;

import java.util.List;

public interface AdminService {
    Admin saveAdmin(Admin admin);          // Create new admin
    Admin getAdminById(Long id);           // Get admin by ID
    List<Admin> getAllAdmins();            // Get all admins
    Admin updateAdmin(Long id, Admin admin); // Update admin details
    void deleteAdmin(Long id);             // Delete admin by ID
    Admin findByUsername(String username); // Find admin by username
}
