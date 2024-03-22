package com.piashraful.learing.spring.boot.project.one.repository;

import com.piashraful.learing.spring.boot.project.one.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
