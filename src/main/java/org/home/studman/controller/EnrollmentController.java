package org.home.studman.controller;

import org.home.studman.domain.Enrollment;
import org.home.studman.service.EnrollmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @GetMapping("/enrollments")
    public List<Enrollment> getAllEnrollments() {
        return enrollmentService.findAll();
    }

    @GetMapping("/enrollments/{id}")
    public ResponseEntity<Enrollment> getEnrollmentById(@PathVariable(value = "id") Long enrollmentId)
            throws ResourceNotFoundException {
        Enrollment enrollment = enrollmentService.findById(enrollmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found for this id :: " + enrollmentId));
        return ResponseEntity.ok().body(enrollment);
    }

    @PostMapping("/enrollments")
    public Enrollment createEnrollment(@RequestBody Enrollment enrollment) {
        return enrollmentService.save(enrollment);
    }

    @PutMapping("/enrollments/{id}")
    public ResponseEntity<Enrollment> updateEnrollment(@PathVariable(value = "id") Long enrollmentId,
                                                       @RequestBody Enrollment enrollmentDetails) throws ResourceNotFoundException {
        Enrollment enrollment = enrollmentService.findById(enrollmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found for this id :: " + enrollmentId));
        enrollment.setGrade(enrollmentDetails.getGrade());
        final Enrollment updatedEnrollment = enrollmentService.update(enrollment);
        return ResponseEntity.ok(updatedEnrollment);
    }

    @DeleteMapping("/enrollments/{id}")
    public Map<String, Boolean> deleteEnrollment(@PathVariable(value = "id") Long enrollmentId)
            throws ResourceNotFoundException {
        Enrollment enrollment = enrollmentService.findById(enrollmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found for this id :: " + enrollmentId));
        enrollmentService.delete(enrollment);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
