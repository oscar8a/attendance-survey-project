package com.attendancesurvey.api.service;

import com.attendancesurvey.api.dtos.CourseCreateDTO;
import com.attendancesurvey.api.models.Course;
import com.attendancesurvey.api.repository.CourseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    private ModelMapper mapper;

    public Course createCourse(CourseCreateDTO courseData){
        return courseRepository.save(mapper.map(courseData, Course.class));
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
