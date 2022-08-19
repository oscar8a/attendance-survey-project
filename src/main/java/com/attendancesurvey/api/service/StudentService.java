package com.attendancesurvey.api.service;

import com.attendancesurvey.api.dtos.AttendanceCreateDTO;
import com.attendancesurvey.api.dtos.StudentCreateDTO;
import com.attendancesurvey.api.models.Attendance;
import com.attendancesurvey.api.models.Course;
import com.attendancesurvey.api.models.Student;
import com.attendancesurvey.api.repository.AttendanceRepository;
import com.attendancesurvey.api.repository.CourseRepository;
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
    CourseRepository courseRepository;

    @Autowired
    private ModelMapper mapper;

    public StudentCreateDTO createStudent(StudentCreateDTO studentData){
        Student resultStudent = studentRepository.save(mapper.map(studentData, Student.class));
        return mapper.map(resultStudent, StudentCreateDTO.class);
    }

    public Attendance createAttendance(AttendanceCreateDTO attendanceData, Integer studentId) {
        Optional<Attendance> attendanceOptional = attendanceRepository.findByAttendanceDate(attendanceData.getAttendanceDate());
        if (attendanceOptional.isPresent()){
            throw new RuntimeException();
        } else {
            Student student = studentRepository.findById(studentId).orElseThrow();
            Course course = courseRepository.findByName(attendanceData.getCourseName()).orElseThrow();

            Attendance attendanceToSave = mapper.map(attendanceData, Attendance.class);

            course.getStudents().add(student);
            course.getAttendanceList().add(attendanceToSave);
            student.getAttendances().add(attendanceToSave);



            Attendance result = attendanceRepository.save(attendanceToSave);
            courseRepository.save(course);
            studentRepository.save(student);

            return result;
        }
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
