package com.piashraful.learing.spring.boot.project.one.service;

import com.piashraful.learing.spring.boot.project.one.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();

    public String createEmployee(Employee employee);

    public Employee getEmployeeById(Long id);

    public String deleteEmployeeById(Long id);

   public String saveEmployees(List<Employee> employees);

   public String updateEmployeeById(Long id, Employee updatedEmployee);
}
