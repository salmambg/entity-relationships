package org.example;


import org.example.entity.Course;
import org.example.entity.Review;
import org.example.repository.CourseRepository;
import org.example.repository.ReviewRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MainJpaApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(MainJpaApplication.class);

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    ReviewRepository reviewRepository;

    public static void main(String[] args) {
        SpringApplication.run(MainJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        addHardcodedReviewsForCourse();
    }

    public void addHardcodedReviewsForCourse() {

        // Retrieve the course with ID 10003
        Course course = courseRepository.findById(10003L).orElse(null);

        if (course != null) {
            logger.info("course.getReviews() -> {}", course.getReviews());

            Review review1 = new Review(50004L,"5", "Very Good Course");
            Review review2 = new Review(50005L, "5", "Hats-off");

            course.addReview(review1);
            review1.setCourse(course);

            course.addReview(review2);
            review2.setCourse(course);

            reviewRepository.save(review1);
            reviewRepository.save(review2);
        }
    }

}