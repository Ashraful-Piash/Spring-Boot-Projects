package com.piashraful.Spring.boot.learing.controller;

import com.piashraful.Spring.boot.learing.entity.Department;
import com.piashraful.Spring.boot.learing.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody  Department department){
        return departmentService.saveDepartment(department);


    }

}