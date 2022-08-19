package com.attendancesurvey.api.service;

import com.attendancesurvey.api.dtos.AttendanceCreateDTO;
import com.attendancesurvey.api.dtos.StudentCreateDTO;
import com.attendancesurvey.api.models.Attendance;
import com.attendancesurvey.api.models.Student;
import com.attendancesurvey.api.repository.AttendanceRepository;
import com.attendancesurvey.api.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AttendanceRepository attendanceRepository;

    @Autowired
    private ModelMapper mapper;

    public Student createUser(StudentCreateDTO studentData){
        return studentRepository.save(mapper.map(studentData, Student.class));
    }

    public Attendance createAttendance(AttendanceCreateDTO attendanceData) {

//        attendanceData.setAttendanceDate(LocalDate.now());

        Optional<Attendance> attendanceOptional = attendanceRepository.findByAttendanceDate(attendanceData.getAttendanceDate());
        if (attendanceOptional.isPresent()){
            throw new RuntimeException();
        } else {
            return attendanceRepository.save(mapper.map(attendanceData, Attendance.class));
        }
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
