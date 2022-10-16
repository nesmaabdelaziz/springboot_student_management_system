package com.studentmanagementsystem.springboot.app.service;

import com.studentmanagementsystem.springboot.app.dao.CourseDAO;
import com.studentmanagementsystem.springboot.app.dao.TeacherDAO;
import com.studentmanagementsystem.springboot.app.entity.Course;
import com.studentmanagementsystem.springboot.app.entity.Student;
import com.studentmanagementsystem.springboot.app.entity.Teacher;
import com.studentmanagementsystem.springboot.app.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImp implements CourseService {

    private CourseDAO courseDAO;
    private TeacherDAO teacherDAO;

    @Autowired
    public CourseServiceImp(CourseDAO courseDAO, TeacherDAO teacherDAO) {
        this.courseDAO = courseDAO;
        this.teacherDAO = teacherDAO;
    }

    @Override
    public void save(Course course) {
        Teacher teacher = teacherDAO.findById(course.getTeacher().getId()).orElseThrow(()->new NotFoundException("not found"));
        courseDAO.save(course);
    }

    @Override
    public void deleteById(int id) {
        Course course = courseDAO.findById(id).orElseThrow(()->new NotFoundException("not found"));
        courseDAO.deleteById(id);
    }

    @Override
    public List<Course> findAll() {
        return courseDAO.findAll();
    }

    @Override
    public Course findById(int id) {
        Course course = courseDAO.findById(id).orElseThrow(()->new NotFoundException("not found"));
        return course;
    }

    @Override
    public List<Student> getStudentsInCourse(int courseId) {
        return courseDAO.getStudentsInCourse(courseId);
    }

    @Override
    public List<Course> viewEnrolledCourses(int studentId) {
        return courseDAO.viewStudentsAssignedCourses(studentId);
    }
}
