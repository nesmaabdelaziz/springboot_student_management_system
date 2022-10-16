package com.studentmanagementsystem.springboot.app.service;

import com.studentmanagementsystem.springboot.app.entity.Course;
import com.studentmanagementsystem.springboot.app.entity.Student;

import java.util.List;

public interface CourseService {

    public void save(Course course);

    public void deleteById(int id);

    public List<Course> findAll();

    public Course findById(int id);

    public List<Student> getStudentsInCourse(int courseId);

    public List<Course> viewEnrolledCourses(int studentId);

}
