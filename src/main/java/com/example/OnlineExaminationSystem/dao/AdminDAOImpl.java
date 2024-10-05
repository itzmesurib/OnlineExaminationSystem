package com.example.OnlineExaminationSystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.OnlineExaminationSystem.entity.Admin;

import jakarta.transaction.Transactional;

@Transactional
public class AdminDAOImpl implements AdminDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Admin saveAdmin(Admin admin) {
        Session session = sessionFactory.getCurrentSession(); // Get current session
        session.persist(admin); // Use Session to persist
        return admin;
    }

    @Override
    public Admin getAdminById(Long id) {
        Session session = sessionFactory.getCurrentSession(); // Get current session
        return session.get(Admin.class, id); // Use Session to get admin by ID
    }

    @Override
    public List<Admin> getAllAdmins() {
        Session session = sessionFactory.getCurrentSession(); // Get current session
        return session.createQuery("FROM Admin", Admin.class).getResultList(); // Use Session to create query
    }

    @Override
    public void updateAdmin(Long id, Admin admin) {
        Session session = sessionFactory.getCurrentSession(); // Get current session
        Admin existingAdmin = session.get(Admin.class, id); // Use Session to find existing admin
        if (existingAdmin != null) {
            existingAdmin.setName(admin.getName());
            existingAdmin.setEmail(admin.getEmail());
            existingAdmin.setPassword(admin.getPassword());
            session.update(existingAdmin); // Use Session to update
        }
    }

    @Override
    public void deleteAdmin(Long id) {
        Session session = sessionFactory.getCurrentSession(); // Get current session
        Admin admin = session.get(Admin.class, id); // Use Session to find admin
        if (admin != null) {
            session.delete(admin); // Use Session to delete
        }
    }
}
