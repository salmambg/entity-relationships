package org.example.repository;

import org.example.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query(name = "query_get_all_courses")
    List<Course> getAllCourse();

    @Query(name = "query_get_100_Step_courses")
    List<Course> getCourse(String s);

    @Query(value = "SELECT * FROM courses WHERE name LIKE  %?1%", nativeQuery = true)
    List<Course> getCourseName(String name);
}
