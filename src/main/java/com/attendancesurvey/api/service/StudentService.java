package com.attendancesurvey.api.service;

import com.attendancesurvey.api.dtos.StudentCreateDTO;
import com.attendancesurvey.api.models.Student;
import com.attendancesurvey.api.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    private ModelMapper mapper;

    public Student createUser(StudentCreateDTO studentData){
        return studentRepository.save(mapper.map(studentData, Student.class));
    }
}
