package org.example.repository;


import org.example.entity.Passport;
import org.example.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.transaction.Transactional;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    PassportRepository passportRepository;

    @Test
    @Transactional
    public void retrieveStudentAndPassportDetails() {
        Optional<Student> optionalStudent = studentRepository.findById(20001L);

        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            assertEquals("Salma", student.getName());
            assertNotNull(student.getPassport());

            System.out.println("Student: " + student.getName());
            System.out.println("Passport: " + student.getPassport().getNumber());
        } else {
            System.out.println("Student with ID 20001 not found.");
        }
    }

    @Test
    @Transactional
    public void retrievePassportAndPStudentDetails() {
        Optional<Passport> optionalPassport = passportRepository.findById(40003L);

        if (optionalPassport.isPresent()) {
            Passport passport = optionalPassport.get();
            assertEquals("K123456", passport.getNumber());
            assertNotNull(passport.getStudent());

            System.out.println("Passport: " + passport.getNumber());
            System.out.println("Student: " +passport.getStudent().getName());
        } else {
            System.out.println("Passport with ID 40003 not found.");
        }

    }

}