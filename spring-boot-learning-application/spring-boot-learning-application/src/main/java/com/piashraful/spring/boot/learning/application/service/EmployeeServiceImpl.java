package com.piashraful.spring.boot.learning.application.service;

import com.piashraful.spring.boot.learning.application.entity.Employee;
import com.piashraful.spring.boot.learning.application.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee deleteEmployeeById(Long id) {
        return null;
    }

    @Override
    public Employee getAllEmployees(Long id) {
        return null;
    }

    @Override
    public Employee deleteEmployeeById() {
        return employeeRepository.deleteById(employeeId).orElse(null);
    }

}
