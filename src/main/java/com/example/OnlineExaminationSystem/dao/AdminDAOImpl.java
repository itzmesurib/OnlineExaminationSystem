package com.example.OnlineExaminationSystem.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.OnlineExaminationSystem.entity.Admin;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AdminDAOImpl implements AdminDAO {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Admin saveAdmin(Admin admin) {
        entityManager.persist(admin);
        return admin;
    }

    @Override
    public Admin getAdminById(Long id) {
        return entityManager.find(Admin.class, id);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return entityManager.createQuery("FROM Admin", Admin.class).getResultList();
    }

    @Override
    public void updateAdmin(Long id, Admin admin) {
        Admin existingAdmin = entityManager.find(Admin.class, id);
        if (existingAdmin != null) {
            existingAdmin.setName(admin.getName());
            existingAdmin.setEmail(admin.getEmail());
            existingAdmin.setPassword(admin.getPassword());
            entityManager.merge(existingAdmin);
        }
    }

    @Override
    public void deleteAdmin(Long id) {
        Admin admin = entityManager.find(Admin.class, id);
        if (admin != null) {
            entityManager.remove(admin);
        }
    }
}
