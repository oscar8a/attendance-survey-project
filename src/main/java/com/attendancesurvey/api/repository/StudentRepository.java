package com.attendancesurvey.api.repository;

import com.attendancesurvey.api.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
