package com.attendancesurvey.api.repository;

import com.attendancesurvey.api.models.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {
    Optional<Attendance> findByAttendanceDate(LocalDate date);
}
