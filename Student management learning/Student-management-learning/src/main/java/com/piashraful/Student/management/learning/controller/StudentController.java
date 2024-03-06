package com.piashraful.Student.management.learning.controller;

import com.piashraful.Student.management.learning.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class StudentController {
    @GetMapping("/students")
    public List<Student> getStudents(){
        return List.of(
                new Student(
                        1L,
                        "Ashraful",
                        (byte) 28,
                        LocalDate.of(1995,6,12),
                        "piashraful@gmail.com"

                )
        );
    }
}
