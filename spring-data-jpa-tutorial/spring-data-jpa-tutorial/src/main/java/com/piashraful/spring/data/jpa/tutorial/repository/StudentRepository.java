package com.piashraful.spring.data.jpa.tutorial.repository;

import com.piashraful.spring.data.jpa.tutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findByFirstName(String firstname);
    public List<Student> findByFirstNameContaining(String name);

    public List<Student> findByEmailId (String emailId);

    @Query("select s from Student s where s.emailId= ?1")
    Student getStudentByEmailId(String emailId);

    @Query("select s.firstName from Student s where s.emailId= ?1")
    String getStudentByEmailIdByName(String emailId);

}
