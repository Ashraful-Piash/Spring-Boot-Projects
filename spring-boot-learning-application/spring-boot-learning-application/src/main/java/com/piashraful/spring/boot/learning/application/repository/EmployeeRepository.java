package com.piashraful.spring.boot.learning.application.repository;

import com.piashraful.spring.boot.learning.application.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    public Employee findByEmployeeNameIgnoreCase(String employeeName);
}
