package com.attendancesurvey.api.repository;

import com.attendancesurvey.api.models.Attendance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AttendanceRepositoryTest {

    @Autowired
    AttendanceRepository repository;

    @Test
    public void findByAttendanceDateTest() {
        Attendance attendance = repository.findByAttendanceDate(
                LocalDate.of(2018, 1, 1)
        ).orElseThrow();

        assertNotNull(attendance);
    }
}