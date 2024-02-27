package com.piashraful.Spring.boot.learing.service;

import com.piashraful.Spring.boot.learing.entity.Department;

import java.util.List;

public interface DepartmentService {


    public List<Department> fetchDepartmentList();

    public Department getDepartmentById(Long id);


    public void deleteDepartmentById(Long departmentId);

    public Department saveDepartment(Department department);
}
