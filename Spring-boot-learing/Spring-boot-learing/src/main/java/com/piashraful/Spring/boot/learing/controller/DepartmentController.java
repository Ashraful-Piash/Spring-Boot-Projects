package com.piashraful.Spring.boot.learing.controller;

import com.piashraful.Spring.boot.learing.entity.Department;
import com.piashraful.Spring.boot.learing.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        logger.info("inside save department");
        return departmentService.saveDepartment(department);

    }


    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        logger.info("inside fetchDepartmentList");
        return departmentService.fetchDepartmentList();
    }

   @GetMapping("/department/{id}")
   public Department getDepartmentById(@PathVariable("id") Long departmentId){
       logger.info("inside getDepartmentById");

        return departmentService.getDepartmentById(departmentId);

   }
    @DeleteMapping("/department/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        logger.info("inside deleteDepartmentById");
        return "Department with id " +departmentId +" is being deleted!";
    }

    @PutMapping("/department/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department){
        return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("/department/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return  departmentService.fetchDepartmentByName(departmentName);
    }

}
