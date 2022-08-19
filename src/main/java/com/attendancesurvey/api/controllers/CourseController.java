package com.attendancesurvey.api.controllers;

import com.attendancesurvey.api.dtos.CourseCreateDTO;
import com.attendancesurvey.api.dtos.StudentCreateDTO;
import com.attendancesurvey.api.models.Course;
import com.attendancesurvey.api.models.Student;
import com.attendancesurvey.api.repository.CourseRepository;
import com.attendancesurvey.api.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired
    CourseService courseService;

//    @Autowired
//    private ModelMapper mapper;

    @PostMapping
    public Course createCourse(@Valid @RequestBody CourseCreateDTO courseData){
        return courseService.createCourse(courseData);
    }

    @GetMapping
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

}
