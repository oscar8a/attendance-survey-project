package com.attendancesurvey.api.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AttendanceCreateDTO {
    private LocalDate attendanceDate;
    private boolean isPresent;
}
