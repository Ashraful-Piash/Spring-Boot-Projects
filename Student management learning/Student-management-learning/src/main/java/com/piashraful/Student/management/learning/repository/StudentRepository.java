package com.piashraful.Student.management.learning.repository;

import com.piashraful.Student.management.learning.entity.Student;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Id> {
}
