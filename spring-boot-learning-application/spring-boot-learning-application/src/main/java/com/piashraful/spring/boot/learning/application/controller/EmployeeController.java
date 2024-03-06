package com.piashraful.spring.boot.learning.application.controller;

import com.piashraful.spring.boot.learning.application.entity.Employee;
import com.piashraful.spring.boot.learning.application.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        logger.info("Inside save employee");
        return employeeService.saveEmployee(employee);
    }
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployeeById(employeeId);
        return "Employee with id " +employeeId + " is being deleted";
    }

    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable ("id") Long employeeId,
                                   @RequestBody Employee employee){
        return employeeService.updateEmployee(employeeId,employee);
    }

    @GetMapping("/employee/name/{name}")
    public Employee getEmployeeByName(@PathVariable("name") String employeeName){
        return employeeService.getEmployeeByName(employeeName);
    }

}


