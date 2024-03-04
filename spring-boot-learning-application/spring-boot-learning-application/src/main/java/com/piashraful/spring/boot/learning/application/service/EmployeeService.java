package com.piashraful.spring.boot.learning.application.service;

import com.piashraful.spring.boot.learning.application.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee saveEmployee(Employee employee);




   public List<Employee> getAllEmployees();

   public Employee getEmployeeById(Long employeeId);

   public void deleteEmployeeById(Long employeeId);

   public Employee updateEmployee(Long employeeId, Employee employee);
}
