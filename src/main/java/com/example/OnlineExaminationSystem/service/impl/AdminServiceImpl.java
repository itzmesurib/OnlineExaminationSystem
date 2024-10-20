package com.example.OnlineExaminationSystem.service.impl;


import com.example.OnlineExaminationSystem.entity.Admin;
import com.example.OnlineExaminationSystem.repository.AdminRepository;
import com.example.OnlineExaminationSystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElseThrow(() -> new RuntimeException("Admin not found"));
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin updateAdmin(Long id, Admin admin) {
        Admin existingAdmin = adminRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Admin not found"));
        existingAdmin.setUsername(admin.getUsername());
        existingAdmin.setPassword(admin.getPassword());
        return adminRepository.save(existingAdmin);
    }

    @Override
    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }

    @Override
    public Admin findByUsername(String username) {
        return adminRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("Admin not found with username: " + username));
    }
}
