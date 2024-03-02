package com.piashraful.spring.boot.learning.application.controller;

import com.piashraful.spring.boot.learning.application.entity.Employee;
import com.piashraful.spring.boot.learning.application.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }
    @GetMapping("/employees}")
    public Employee getAllEmployees(@PathVariable Long id){
        return employeeService.getAllEmployees(id);
    }
    @DeleteMapping("/employee/{id}")
    public Employee deleteEmployeeById(){
        return employeeService.deleteEmployeeById(Long employeeId);
    }


}


