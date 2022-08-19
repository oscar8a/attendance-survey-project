package com.attendancesurvey.api.repository;

import com.attendancesurvey.api.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
