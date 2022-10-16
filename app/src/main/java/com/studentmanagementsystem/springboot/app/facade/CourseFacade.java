package com.studentmanagementsystem.springboot.app.facade;

import com.studentmanagementsystem.springboot.app.dto.CourseDTO;
import com.studentmanagementsystem.springboot.app.entity.Student;

import java.util.List;

public interface CourseFacade {
    public void save(CourseDTO courseDTO);


    public void deleteById(int id);

    public List<CourseDTO> findAll();

    public CourseDTO findById(int id);

    public List<Student> getStudentsInCourse(int courseId);

    public List<CourseDTO> viewEnrolledCourses(int studentId);

}
