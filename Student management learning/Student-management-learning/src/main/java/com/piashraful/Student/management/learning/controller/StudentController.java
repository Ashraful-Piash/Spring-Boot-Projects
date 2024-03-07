package com.piashraful.Student.management.learning.controller;

import com.piashraful.Student.management.learning.entity.Student;
import com.piashraful.Student.management.learning.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }
    @PostMapping("/students")
    public Student saveAllStudents(@RequestBody Student student){
        return studentService.saveAllStudents(student);

    }
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable("id") Long studentId){
        return studentService.getStudentById(studentId);
    }

    @DeleteMapping("/students/{id}")
        public void deleteStudentById(@PathVariable("id") Long studentId){
        studentService.deleteStudentById(studentId);
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable("id") Long studentId,
                                 @RequestBody Student student){
        return studentService.updateStudent(studentId, student);
    }




}
