package com.piashraful.learing.spring.boot.project.one.controller;

import com.piashraful.learing.spring.boot.project.one.entity.Employee;
import com.piashraful.learing.spring.boot.project.one.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    public String createEmployee(@RequestBody Employee employee){
        employees.add(employee);
        return "created successfully";
    }

}
