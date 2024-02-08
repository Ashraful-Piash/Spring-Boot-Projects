package com.piashraful.Spring.boot.learing.service;

import com.piashraful.Spring.boot.learing.entity.Department;
import com.piashraful.Spring.boot.learing.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }
}
