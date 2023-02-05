package org.home.studman.repository;

import org.home.studman.domain.Course;
import org.home.studman.domain.Enrollment;
import org.home.studman.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT c FROM Course c JOIN Enrollment e ON c.id = e.course.id WHERE e.student.id = :id")
    List<Course> findCoursesByStudentId(Long id);

    @Query("SELECT e FROM Enrollment e WHERE e.student.id = :id")
    List<Enrollment> findEnrollmentsByStudentId(Long id);
}
