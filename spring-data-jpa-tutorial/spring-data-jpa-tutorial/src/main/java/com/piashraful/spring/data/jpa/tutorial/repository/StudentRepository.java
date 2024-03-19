package com.piashraful.spring.data.jpa.tutorial.repository;

import com.piashraful.spring.data.jpa.tutorial.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

    @Query(
            value = "select * from table_student s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);

    @Modifying
    @Transactional
    @Query(
            value = "update table_student set first_name =?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateStudentByEmailId(String firstName, String emailId);

}
