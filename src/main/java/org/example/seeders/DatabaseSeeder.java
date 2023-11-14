package org.example.seeders;

import org.example.entity.*;
import org.example.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
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
    @Autowired
    EmployeeRepository employeeRepository;

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        logger.info("insert course data");
        seedCourseData();
        seedPassportData();
        seedStudentData();
        ReviewData();
        seedStudentCourseData();
        seedEmployeeData();
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
        logger.info("passport1 -> {}", passport1);
        if (passport1 != null) {
            student1.setPassport(passport1);
        }
        students.add(student1);


        Student student2 = new Student();
        student2.setId(20002);
        student2.setName("Samiha");
        Passport passport2 = passportRepository.findById(40002L).orElse(null);
        if (passport2 != null) {
            student2.setPassport(passport2);
        }
        students.add(student2);

        Student student3 = new Student();
        student3.setId(20003);
        student3.setName("Sabiha");

        Passport passport3 = passportRepository.findById(40003L).orElse(null);
        if (passport3 != null) {
            student3.setPassport(passport3);
        }
        students.add(student3);
        studentRepository.saveAll(students);
    }

    private void ReviewData() {
        List<Review> reviews = new ArrayList<>();
        Course course1 = courseRepository.findById(10001L).orElse(null);
        if (course1 != null) {
            Review review1 = new Review();
            review1.setId(50001);
            review1.setRating("FIVE");
            review1.setDescription("Great Course");
            review1.setCourse(course1);
            reviews.add(review1);

            Review review2 = new Review();
            review2.setId(50002);
            review2.setRating("FOUR");
            review2.setDescription("Wonderful Course");
            review2.setCourse(course1);
            reviews.add(review2);
        }
        // Review 3 associated with Course 10003
        Course course3 = courseRepository.findById(10003L).orElse(null);
        if (course3 != null) {
            Review review3 = new Review();
            review3.setId(50003);
            review3.setRating("FIVE");
            review3.setDescription("Awesome Course");
            review3.setCourse(course3);
            reviews.add(review3);
        }
        reviewRepository.saveAll(reviews);
    }
    private void seedStudentCourseData() {
        List<Student> students = new ArrayList<>();

        Course course1 = courseRepository.findById(10001L).orElse(null);
        if (course1 != null) {
            List<Course> courseList = new ArrayList<>();
            courseList.add(course1);
            Student student1= studentRepository.findById(20001L).orElse(null);
            student1.setCourses(courseList);
            students.add(student1);
        }

        Course course2 = courseRepository.findById(10002L).orElse(null);
        if (course2 != null) {
            List<Course> courseList = new ArrayList<>();
            courseList.add(course2);
            courseList.add(course1);
            Student student2= studentRepository.findById(20002L).orElse(null);
            student2.setCourses(courseList);
            students.add(student2);
        }

        Student student3 =  studentRepository.findById(20003L).orElse(null);
        Course course3 = courseRepository.findById(10003L).orElse(null);

        if (course1 != null && course3 != null) {
            List<Course> courseList = new ArrayList<>();
            courseList.add(course3);
            courseList.add(course2);
            student3.setCourses(courseList);
            students.add(student3);
        }
        studentRepository.saveAll(students);
    }
    private void seedEmployeeData() {
        List<Employee> employees = new ArrayList<>();
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee();
        fullTimeEmployee.setId(30001L);
        fullTimeEmployee.setName("Jack");
        fullTimeEmployee.setSalary(new BigDecimal("10000"));
        employees.add(fullTimeEmployee);

        PartTimeEmployee partTimeEmployee = new PartTimeEmployee();
        partTimeEmployee.setId(30002L);
        partTimeEmployee.setName("Jill");
        partTimeEmployee.setHourlyWage(new BigDecimal("50"));
        employees.add(partTimeEmployee);

        employeeRepository.saveAll(employees);

    }
}
