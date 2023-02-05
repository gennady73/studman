package org.home.studman;

import org.home.studman.domain.Student;
import org.home.studman.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    void testGetAllStudents() {
        List<Student> students = studentService.getAllStudents();
        assertNotNull(students);
        assertTrue(!students.isEmpty());
    }

    @Test
    void testGetStudentById() {
        Student student = studentService.getStudentById(1L);
        assertNotNull(student);
        assertEquals("John Doe", student.getFirstName());
    }

    // Add more tests for other methods in StudentService
}
