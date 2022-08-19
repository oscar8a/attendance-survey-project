package com.attendancesurvey.api.service;

import com.attendancesurvey.api.dtos.AttendanceCreateDTO;
import com.attendancesurvey.api.models.Attendance;
import com.attendancesurvey.api.repository.AttendanceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {
    @Autowired
    AttendanceRepository attendanceRepository;

    @Autowired
    private ModelMapper mapper;

//    public Attendance createAttendance(AttendanceCreateDTO attendanceData){
//        Optional<Attendance> attendanceOptional = attendanceRepository.findByAttendanceDate(attendanceData.getAttendanceDate());
//        if (attendanceOptional.isPresent()){
//            return attendanceRepository.save(mapper.map(attendanceData, Attendance.class));
//        } else {
//            throw new RuntimeException();
//        }
//    }

    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }
}
