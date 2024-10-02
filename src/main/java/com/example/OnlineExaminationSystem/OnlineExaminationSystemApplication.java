package com.example.OnlineExaminationSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import com.example.OnlineExaminationSystem.dao.StudentDAOImpl;
import com.example.OnlineExaminationSystem.entity.Student;

@SpringBootApplication(scanBasePackages = "com.example.OnlineExaminationSystem")
public class OnlineExaminationSystemApplication {

	public static void main(String[] args) {
		
		
		SpringApplication.run(OnlineExaminationSystemApplication.class, args);
		
		
		Student s = new Student();
		s.setName("Surendra Babu");
		s.setId(1L);
		s.setEmail("surendra@gmail.com");
		s.setPassword("password");
		s.setPhoneNumber("7938930293");
		s.setQualification("B.Tech");
		
		StudentDAOImpl sd = new StudentDAOImpl();
		sd.saveStudent(s);
	}

}
