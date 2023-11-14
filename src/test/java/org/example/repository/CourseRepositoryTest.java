package org.example.repository;

import org.example.entity.Course;
import org.example.entity.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.transaction.Transactional;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    ReviewRepository reviewRepository;

    @Test
    @Transactional
    public void retrieveReviewForCourse() {
        Optional<Course> optionalCourse = courseRepository.findById(10001L);

        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            assertEquals("JPA in 50 Steps", course.getName());
            assertNotNull(course.getReviews());

            System.out.println("Course : "+ course.getName());
            System.out.println("Reviews: " + course.getReviews());
        }else {
            System.out.println("Course with ID 10001 not found.");
        }
    }

    @Test
    @Transactional
    public void retrieveCourseForReview() {
        Optional<Review> optionalReview = reviewRepository.findById(50001L);

        if (optionalReview.isPresent()) {
            Review review =optionalReview.get();
            assertEquals("Great Course", review.getDescription());
            assertNotNull(review.getCourse());

            System.out.println("Review : "+ review.getDescription());
            System.out.println("Course: " + review.getCourse());
        }else {
            System.out.println("Review with ID 50001 not found.");
        }
    }
    @Test
    public void pagination() {
        PageRequest pageRequest = PageRequest.of(0,2);
        Page<Course> firstPage = courseRepository.findAll(pageRequest);
        System.out.println("First Page Content: " + firstPage.getContent());
        assertEquals(2, firstPage.getContent().size());
        firstPage.hasContent();

        Page<Course> secondPage = courseRepository.findAll(firstPage.nextPageable());
        assertEquals(2,secondPage.getContent().size());
        secondPage.hasContent();
    }
}
