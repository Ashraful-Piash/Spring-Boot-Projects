package com.piashraful.Student.management.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.*")
public class StudentManagementLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementLearningApplication.class, args);
	}

}
