package com.attendancesurvey.api.controllers;

import javax.validation.Valid;

import com.attendancesurvey.api.dtos.AttendanceCreateDTO;
import com.attendancesurvey.api.dtos.StudentCreateDTO;
import com.attendancesurvey.api.models.Attendance;
import com.attendancesurvey.api.models.Student;
import com.attendancesurvey.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    public Student createStudent(@Valid @RequestBody StudentCreateDTO studentData){
        return studentService.createUser(studentData);
    }

    @PostMapping("/{id}/attendance")
    public Attendance createAttendance(@Valid @RequestBody AttendanceCreateDTO attendanceData, @PathVariable int id) {
        attendanceData.setAttendanceDate(LocalDate.now());
        return studentService.createAttendance(attendanceData);
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

}
