package com.piashraful.learing.spring.boot.project.one.controller;

import com.piashraful.learing.spring.boot.project.one.entity.Employee;
import com.piashraful.learing.spring.boot.project.one.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employee")
    public String createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PostMapping("/employees")
    public String saveEmployees(@RequestBody List<Employee> employees) {
        return employeeService.saveEmployees(employees);
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id) {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long id) {
        return employeeService.deleteEmployeeById(id);

    }

    @PutMapping("/employees/{id}")
    public String updateEmployeeById(@PathVariable("id") Long id , @RequestBody Employee updatedEmployee){
        return employeeService.updateEmployeeById(id, updatedEmployee);

    }

}
