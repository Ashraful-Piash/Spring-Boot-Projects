package com.piashraful.Student.management.learning.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)


    private Long studentId;
    private String studentName;
    @Transient
    private byte studentAge;
    private LocalDate dateOfBirth;
    private String email;
    public Student(String studentName, LocalDate dateOfBirth, String email) {
        this.studentName = studentName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }
    public byte getStudentAge(){
        LocalDate currentDate = LocalDate.now();
        return (byte) Period.between(dateOfBirth,currentDate).getYears();
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", email='" + email + '\'' +
                '}';
    }
}
