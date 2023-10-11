package org.example.seeders;

import org.example.entity.Course;
import org.example.entity.Passport;
import org.example.entity.Review;
import org.example.entity.Student;
import org.example.repository.CourseRepository;
import org.example.repository.PassportRepository;
import org.example.repository.ReviewRepository;
import org.example.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseSeeder.class);

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    PassportRepository passportRepository;
    @Autowired
    ReviewRepository reviewRepository;

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        logger.info("insert course data");
        seedCourseData();
        seedPassportData();
        seedStudentData();
        ReviewData();
        logger.info("finish insert course data");
    }

    private void seedCourseData() {
        List<Course> courses = new ArrayList<>();

        Course course1 = new Course();
        course1.setId(10001L);
        course1.setName("JPA in 50 Steps");
        courses.add(course1);

        Course course2 = new Course();
        course2.setId(10002L);
        course2.setName("Spring Boot Basics ");
        courses.add(course2);

        Course course3 = new Course();
        course3.setId(10003L);
        course3.setName("Hibernate Fundamentals");
        courses.add(course3);

        Course course4 = new Course();
        course4.setId(10004L);
        course4.setName("Hibernate and JPA Fundamentals");
        courses.add(course4);

        courseRepository.saveAll(courses);
    }

    private void seedPassportData() {
        List<Passport> passports = new ArrayList<>();

        Passport passport1 = new Passport();
        passport1.setId(40001);
        passport1.setNumber("N123456");
        passports.add(passport1);

        Passport passport2 = new Passport();
        passport2.setId(40002);
        passport2.setNumber("E123456");
        passports.add(passport2);

        Passport passport3 = new Passport();
        passport3.setId(40003);
        passport3.setNumber("K123456");
        passports.add(passport3);

        passportRepository.saveAll(passports);
    }

    private void seedStudentData() {
        List<Student> students = new ArrayList<>();

        Student student1 = new Student();
        student1.setId(20001);
        student1.setName("Salma");
        Passport passport1 = passportRepository.findById(40001L).orElse(null);
        if (passport1 != null) {
            student1.setPassport(passport1);
            students.add(student1);
        }

        Student student2 = new Student();
        student2.setId(20002);
        student2.setName("Samiha");


        Passport passport2 = passportRepository.findById(40002L).orElse(null);
        if (passport2 != null) {
            student2.setPassport(passport2);
            students.add(student2);
        }

        Student student3 = new Student();
        student3.setId(20003);
        student3.setName("Sabiha");

        Passport passport3 = passportRepository.findById(40003L).orElse(null);
        if (passport3 != null) {
            student3.setPassport(passport3);
            students.add(student3);
        }
        studentRepository.saveAll(students);
    }

    private void ReviewData() {
        List<Review> reviews = new ArrayList<>();

        Review review1 = new Review();
        review1.setId(50001);
        review1.setRating("5");
        review1.setDescription("Great Course");
        reviews.add(review1);

        Review review2 = new Review();
        review2.setId(50002);
        review2.setRating("4");
        review2.setDescription("Good Course");
        reviews.add(review2);

        Review review3 = new Review();
        review3.setId(50003);
        review3.setRating("5");
        review3.setDescription("Wonderful Course");
        reviews.add(review3);

        reviewRepository.saveAll(reviews);

    }

}
