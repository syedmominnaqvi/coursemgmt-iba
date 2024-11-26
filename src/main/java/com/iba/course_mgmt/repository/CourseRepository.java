package com.iba.course_mgmt.repository;

import com.iba.course_mgmt.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String> {
    // Custom query methods can be added here if needed
}
