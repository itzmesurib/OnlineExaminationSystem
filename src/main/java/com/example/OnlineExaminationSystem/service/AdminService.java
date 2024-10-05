package com.example.OnlineExaminationSystem.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.OnlineExaminationSystem.entity.Admin;


@Service
@Transactional
public class AdminService {

    private final SessionFactory sessionFactory;

    @Autowired
    public AdminService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Save an admin
    public Admin saveAdmin(Admin admin) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(admin);
            session.getTransaction().commit();
        }
        return admin;
    }

    // Get all admins
    public List<Admin> getAllAdmins() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Admin", Admin.class).list();
        }
    }

    // Get an admin by ID
    public Optional<Admin> getAdminById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Admin admin = session.get(Admin.class, id);
            return Optional.ofNullable(admin);
        }
    }

    // Update an admin
    public Admin updateAdmin(Long id, Admin adminDetails) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Admin admin = session.get(Admin.class, id);
            if (admin == null) {
                session.getTransaction().rollback();
                throw new RuntimeException("Admin not found with id: " + id);
            }

            admin.setName(adminDetails.getName());
            admin.setEmail(adminDetails.getEmail());
            // Set other fields here

            session.update(admin);
            session.getTransaction().commit();
            return admin;
        }
    }

    // Delete an admin by ID
    public boolean deleteAdmin(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Admin admin = session.get(Admin.class, id);
            if (admin != null) {
                session.delete(admin);
                session.getTransaction().commit();
                return true;
            } else {
                session.getTransaction().rollback();
                return false;
            }
        }
    }
}
