package com.example.OnlineExaminationSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.OnlineExaminationSystem.entity.Admin;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public AdminService(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    // Save an admin
    @Transactional
    public Admin saveAdmin(Admin admin) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(admin);
        entityManager.getTransaction().commit();
        entityManager.close();
        return admin;
    }

    // Get all admins
    public List<Admin> getAllAdmins() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Admin> admins = entityManager.createQuery("from Admin", Admin.class).getResultList();
        entityManager.close();
        return admins;
    }

    // Get an admin by ID
    public Optional<Admin> getAdminById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Admin admin = entityManager.find(Admin.class, id);
        entityManager.close();
        return Optional.ofNullable(admin);
    }

    // Update an admin
    @Transactional
    public Admin updateAdmin(Long id, Admin adminDetails) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Admin admin = entityManager.find(Admin.class, id);
        if (admin == null) {
            entityManager.getTransaction().rollback();
            entityManager.close();
            throw new RuntimeException("Admin not found with id: " + id);
        }

        admin.setName(adminDetails.getName());
        admin.setEmail(adminDetails.getEmail());
        // Set other fields here

        entityManager.merge(admin);
        entityManager.getTransaction().commit();
        entityManager.close();

        return admin;
    }

    // Delete an admin by ID
    @Transactional
    public boolean deleteAdmin(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Admin admin = entityManager.find(Admin.class, id);
        if (admin != null) {
            entityManager.remove(admin);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        } else {
            entityManager.getTransaction().rollback();
            entityManager.close();
            return false;
        }
    }
}
