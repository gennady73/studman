package org.home.studman.service;

import org.home.studman.controller.ResourceNotFoundException;
import org.home.studman.domain.Course;
import org.home.studman.domain.Enrollment;
import org.home.studman.domain.Student;
import org.home.studman.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student id: " +  id));
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student studentDetails) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student id: " +  id));

        student.setFirstName(studentDetails.getFirstName());
        student.setLastName(studentDetails.getLastName());
        student.setEmail(studentDetails.getEmail());
        student.setAge(studentDetails.getAge());

        Student updatedStudent = studentRepository.save(student);
        return updatedStudent;
    }

    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student id: " +  id));
        studentRepository.delete(student);
    }

    public List<Course> getCoursesByStudentId(Long id) {
        return studentRepository.findCoursesByStudentId(id);
    }

    public List<Enrollment> getEnrollmentsByStudentId(Long studentId) {
        return studentRepository.findEnrollmentsByStudentId(studentId);
    }
}

