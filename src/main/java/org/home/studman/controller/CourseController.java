package org.home.studman.controller;

import org.home.studman.domain.Course;
import org.home.studman.repository.CourseRepository;
import org.home.studman.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studman/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable(value = "id") Long courseId) {
        return courseService.getCourseById(courseId);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable(value = "id") Long courseId,
                               @RequestBody Course courseDetails) {
        return courseService.updateCourse(courseId, courseDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable(value = "id") Long courseId) {
        courseService.deleteCourse(courseId);
    }
}
