package com.iba.course_mgmt.controller;

import com.iba.course_mgmt.model.Course;
import com.iba.course_mgmt.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CoursesController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public List<Course> getCourses() {
        return courseRepository.findAll(); // Fetch all courses
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseRepository.save(course); // Save a new course
    }

    @GetMapping("test")
    public String test() {
        return "Hello, World!";
    }
}
