package com.attendancesurvey.api.controllers;

import com.attendancesurvey.api.dtos.AttendanceCreateDTO;
import com.attendancesurvey.api.dtos.StudentCreateDTO;
import com.attendancesurvey.api.models.Attendance;
import com.attendancesurvey.api.models.Student;
import com.attendancesurvey.api.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {
    @Autowired
    AttendanceService attendanceService;

//    @PostMapping
//    public Attendance createAttendance(@Valid @RequestBody AttendanceCreateDTO attendanceData){
//        return attendanceService.createAttendance(attendanceData);
//    }

    @GetMapping
    public List<Attendance> getAllAttendance() {
        return attendanceService.getAllAttendance();
    }
}
