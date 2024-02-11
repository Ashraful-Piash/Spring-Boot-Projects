package com.piashraful.Spring.boot.learing.service;

import com.piashraful.Spring.boot.learing.entity.Department;

import java.util.List;

public interface DepartmentService {

   public Department saveDepartment(Department department);

  public List<Department> fetchDepartmentList();
}
