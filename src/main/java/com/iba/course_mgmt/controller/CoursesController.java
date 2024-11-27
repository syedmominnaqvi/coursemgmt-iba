package com.iba.course_mgmt.controller;

import com.iba.course_mgmt.model.Course;
import com.iba.course_mgmt.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
public class CoursesController {

    @Autowired
    private CourseRepository courseRepository;

    // Fetch all courses
    @GetMapping
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    // Create a new course
    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    // Fetch a course by ID
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable String id) {
        Optional<Course> course = courseRepository.findById(id);
        return course.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Update an existing course by ID
    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable String id, @RequestBody Course updatedCourse) {
        return courseRepository.findById(id)
                .map(course -> {
                    boolean updated = false;

                    // Update only if the title is different
                    if (updatedCourse.getTitle() != null && !updatedCourse.getTitle().equals(course.getTitle())) {
                        course.setTitle(updatedCourse.getTitle());
                        updated = true;
                    }

                    // Update only if the description is different
                    if (updatedCourse.getDescription() != null && !updatedCourse.getDescription().equals(course.getDescription())) {
                        course.setDescription(updatedCourse.getDescription());
                        updated = true;
                    }

                    // Add checks for other fields as needed...

                    if (updated) {
                        Course savedCourse = courseRepository.save(course);
                    }
                    return ResponseEntity.ok(course); // Return unchanged course
                })
                .orElse(ResponseEntity.notFound().build());
    }


    // Delete a course by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCourse(@PathVariable String id) {
        return courseRepository.findById(id)
                .map(course -> {
                    courseRepository.delete(course);
                    return ResponseEntity.ok().build(); // 204 No Content
                })
                .orElse(ResponseEntity.notFound().build()); // 404 Not Found
    }

    // Fetch courses by name (example query)
    @GetMapping("/search")
    public List<Course> searchCoursesByName(@RequestParam String title) {
        return courseRepository.findByTitleContainingIgnoreCase(title);
    }

    // Test endpoint
    @GetMapping("/test")
    public String test() {
        return "Hello, World!";
    }
}
