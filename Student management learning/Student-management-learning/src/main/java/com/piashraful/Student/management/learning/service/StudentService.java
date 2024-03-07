package com.piashraful.Student.management.learning.service;

import com.piashraful.Student.management.learning.entity.Student;

import java.util.List;

public interface StudentService {
   public List<Student> getStudents();

   public Student saveAllStudents(Student student);

   public Student getStudentById(Long studentId);

   public void deleteStudentById(Long studentId);

  public Student updateStudent(Long studentId, Student student);
}
