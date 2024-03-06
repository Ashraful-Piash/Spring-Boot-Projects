package com.piashraful.Student.management.learning.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)


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
