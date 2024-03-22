package com.piashraful.learing.spring.boot.project.one.service;

import com.piashraful.learing.spring.boot.project.one.entity.Employee;
import com.piashraful.learing.spring.boot.project.one.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public String createEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "Saved successfully";
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public String deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
        return "employee with id:" + id + "delted successfully";
    }

    @Override
    public String saveEmployees(List<Employee> employees) {
         employeeRepository.saveAll(employees);
         return "All Employees saved";
    }

    @Override
    public String updateEmployeeById(Long id, Employee updatedEmployee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            employee.setName(updatedEmployee.getName());
            employee.setEmail(updatedEmployee.getEmail());
            employee.setPhone(updatedEmployee.getPhone());
            employeeRepository.save(employee);

            return "Employee with id " +id + " updated successfully";
        }else {
            return "Employee not found with id :" + id;
        }
    }

}
