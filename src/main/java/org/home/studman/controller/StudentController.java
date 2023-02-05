package org.home.studman.controller;

import org.home.studman.domain.Course;
import org.home.studman.domain.Enrollment;
import org.home.studman.domain.Student;
import org.home.studman.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studman/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable(value = "id") Long studentId) {
        return studentService.getStudentById(studentId);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable(value = "id") Long studentId,
                                 @RequestBody Student studentDetails) {
        return studentService.updateStudent(studentId, studentDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable(value = "id") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @GetMapping("/{id}/courses")
    public List<Course> getAllCoursesByStudentId(@PathVariable(value = "id") Long studentId) {
        return studentService.getCoursesByStudentId(studentId);
    }

    @GetMapping("/{id}/enrollments")
    public List<Enrollment> getAllEnrollmentsByStudentId(@PathVariable(value = "id") Long studentId) {
        return studentService.getEnrollmentsByStudentId(studentId);
    }
}

