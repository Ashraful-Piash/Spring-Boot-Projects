package com.piashraful.Student.management.learning.service;

import com.piashraful.Student.management.learning.entity.Student;
import com.piashraful.Student.management.learning.exception.InvalidUserDataException;
import com.piashraful.Student.management.learning.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);



    @Autowired
    private StudentRepository studentRepository;



    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveAllStudents(Student student) {
        try {
            Optional<Student> optionalStudent = studentRepository.findStudentByEmail(student.getEmail());
            if (optionalStudent.isPresent()) {
                throw new InvalidUserDataException("Email already taken");
            }
            return studentRepository.save(student);
        } catch (InvalidUserDataException e) {
            e.printStackTrace();
            throw e;
        }
    }



    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        if(studentRepository.existsById(studentId)){
            studentRepository.deleteById(studentId);
            logger.info("User with ID {} deleted successfully", studentId);
        } else {
            logger.info("User with ID {} not found", studentId);
        }

    }


    @Override
    public Student updateStudent(Long studentId, Student student) {
        Student studentDb = studentRepository.findById(studentId).get();
        if(Objects.nonNull(student.getStudentName()) && !"".equalsIgnoreCase(student.getStudentName())){
            studentDb.setStudentName(student.getStudentName());
        }

        if(Objects.nonNull(student.getEmail()) && !"".equalsIgnoreCase(student.getEmail())){
            studentDb.setEmail(student.getEmail());
        }
        if (Objects.nonNull(student.getDateOfBirth())) {
            String dobAsString = student.getDateOfBirth().toString(); // Convert LocalDate to String
            studentDb.setDateOfBirth(LocalDate.parse(dobAsString));
        }
        return studentRepository.save(studentDb);
    }

    @Override
    public Student getStudentByStudentName(String studentName) {
        return studentRepository.findByStudentName(studentName);
    }
}

