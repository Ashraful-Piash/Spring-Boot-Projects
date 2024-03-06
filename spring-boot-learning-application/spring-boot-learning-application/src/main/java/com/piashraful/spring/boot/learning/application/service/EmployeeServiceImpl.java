package com.piashraful.spring.boot.learning.application.service;

import com.piashraful.spring.boot.learning.application.entity.Employee;
import com.piashraful.spring.boot.learning.application.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }


    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).get();
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {
        employeeRepository.deleteById(employeeId);

    }

    @Override
    public Employee updateEmployee(Long employeeId, Employee employee) {
        Employee employeeDb = employeeRepository.findById(employeeId).get();

        if(Objects.nonNull(employee.getEmployeeName()) && !"".equalsIgnoreCase(employee.getEmployeeName())){
            employeeDb.setEmployeeName(employee.getEmployeeName());
        }
        if(Objects.nonNull(employee.getEmployeeEmail()) && !"".equalsIgnoreCase(employee.getEmployeeEmail())){
            employeeDb.setEmployeeEmail(employee.getEmployeeEmail());
        }
        if(Objects.nonNull(employee.getEmployeeAddress()) && !"".equalsIgnoreCase(employee.getEmployeeAddress())){
            employeeDb.setEmployeeAddress(employee.getEmployeeAddress());
        }
        return employeeRepository.save(employeeDb);
    }

    @Override
    public Employee getEmployeeByName(String employeeName) {
        return employeeRepository.findByEmployeeNameIgnoreCase(employeeName);
    }


}
