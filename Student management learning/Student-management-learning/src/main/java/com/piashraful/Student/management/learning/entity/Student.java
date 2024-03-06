package com.piashraful.Student.management.learning.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {


    private Long studentId;
    private String studentName;
    private byte studentAge;
    private LocalDate dateOfBirth;
    private String email;
    public Student(String studentName, byte studentAge, LocalDate dateOfBirth, String email) {
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentAge=" + studentAge +
                ", dateOfBirth=" + dateOfBirth +
                ", email='" + email + '\'' +
                '}';
    }
}
