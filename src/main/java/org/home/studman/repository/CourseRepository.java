package org.home.studman.repository;

import org.home.studman.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    @Override
    List<Course> findAll();
}