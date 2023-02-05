package org.home.studman.service;

import org.home.studman.domain.Course;
import org.home.studman.domain.Enrollment;
import org.home.studman.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {

    private EnrollmentRepository enrollmentRepository;

    @Autowired
    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public List<Enrollment> findAll() {
        return enrollmentRepository.findAll();
    }

    public Optional<Enrollment> findById(Long id) {
        return enrollmentRepository.findById(id);
    }

    public Enrollment save(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    public void delete(Enrollment enrollment) {
        enrollmentRepository.delete(enrollment);
    }

    public List<Enrollment> findTop3ByCourseOrderByGradeDesc(Course course) {
        return enrollmentRepository.findTop3ByCourseOrderByGradeDesc(course.getId());
    }

    public List<Enrollment> findByCourse(Course course) {
        return enrollmentRepository.findByCourse(course);
    }

    public Enrollment update(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }
}
