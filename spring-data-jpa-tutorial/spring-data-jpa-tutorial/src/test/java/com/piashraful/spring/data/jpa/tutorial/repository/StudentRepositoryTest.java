package com.piashraful.spring.data.jpa.tutorial.repository;

import com.piashraful.spring.data.jpa.tutorial.entity.Guardian;
import com.piashraful.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    public Guardian guardian;

    @Test
    public void saveStudent() {
        Student student = Student.builder().
                firstName("Ashraful")
                .lastName("haque")
                .emailId("@gmail.com")
//                .guardianName("shilpi akter")
//                .guardianMobile("999999")
//                .guardianEmail("@mail")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void getAllStudent() {
        List<Student> students = studentRepository.findAll();
        System.out.println("Student List : " + students);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("Shilpi")
                .email("shili@")
                .mobile("99999")
                .build();

        Student student = Student.builder()
                .firstName("ashraful")
                .lastName("piash")
                .emailId("@haque")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void findStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("ashraful");
        System.out.println("Students: " + students);
    }

    @Test
    public void findStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("sh");
        System.out.println("Students: " + students);
    }

    @Test
    public void findStudentByEmailId() {
        List<Student> students = studentRepository.findByEmailId("@gmail.com");
        System.out.println(students);
    }

    @Test
    public void findStudentByEmailAddress() {
        Student students = studentRepository.getStudentByEmailId("@gmail.com");
        System.out.println("Student by email Id "+students);

    }
    @Test
    public void findStudentByEmailAddressName() {
        String students = studentRepository.getStudentByEmailIdByName("@gmail.com");
        System.out.println("Student firstname: "+students);

    }


}