package org.home.studman.repository;

import org.home.studman.domain.Course;
import org.home.studman.domain.Enrollment;
import org.home.studman.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    List<Enrollment> findByCourse(Course course);

    @Query(value = "SELECT * FROM enrollment e " +
            "WHERE e.course_id = :courseId ORDER BY e.grade DESC LIMIT 3",
            nativeQuery = true)
    List<Enrollment> findTop3ByCourseOrderByGradeDesc(@Param("courseId") Long courseId);

    List<Enrollment> findAllByCourse(Course course);

    List<Enrollment> findByStudent(Student student);
}
