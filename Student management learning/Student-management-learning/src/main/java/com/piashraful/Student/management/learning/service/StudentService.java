package com.piashraful.Student.management.learning.service;

import com.piashraful.Student.management.learning.entity.Student;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudents() {
        return List.of(
                new Student(
                        1L,
                        "Ashraful",
                        (byte) 28,
                        LocalDate.of(1995, 6, 12),
                        "piashraful@gmail.com"

                )
        );
    }
}
