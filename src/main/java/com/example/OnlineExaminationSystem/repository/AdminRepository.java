package com.example.OnlineExaminationSystem.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OnlineExaminationSystem.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    // You can define custom queries if needed (e.g., findByUsername)
	Optional<Admin> findByUsername(String username);
}
