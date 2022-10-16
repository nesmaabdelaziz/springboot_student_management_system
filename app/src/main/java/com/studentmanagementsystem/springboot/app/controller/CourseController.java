package com.studentmanagementsystem.springboot.app.controller;

import com.studentmanagementsystem.springboot.app.dto.CourseDTO;
import com.studentmanagementsystem.springboot.app.entity.Course;
import com.studentmanagementsystem.springboot.app.entity.Student;
import com.studentmanagementsystem.springboot.app.entity.Teacher;
import com.studentmanagementsystem.springboot.app.facade.CourseFacade;
import com.studentmanagementsystem.springboot.app.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @GetMapping("/courses")
    public List<Course> viewAllCourses() {
        return courseService.findAll();
    }

    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable int courseId) {
        Course course = courseService.findById(courseId);
        return course;
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody CourseDTO courseDTO) {
        courseDTO.setId(0);
        Course course = new Course();
        course.setId(courseDTO.getId());
        course.setName(courseDTO.getName());
        Teacher teacher = new Teacher();
        teacher.setId(courseDTO.getTeacherId());
        course.setTeacher(teacher);
        courseService.save(course);
        return course;
    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody CourseDTO courseDTO) {
        Course course = new Course();
        course.setId(courseDTO.getId());
        course.setName(courseDTO.getName());
        Teacher teacher = new Teacher();
        teacher.setId(courseDTO.getTeacherId());
        course.setTeacher(teacher);
        courseService.save(course);
        return course;
    }

    @DeleteMapping("/courses/{courseId}")
    public String removeCourse(@PathVariable int courseId) {
        Course course = courseService.findById(courseId);
        courseService.deleteById(courseId);

        return "Deleted Course id - " + courseId;
    }

    @GetMapping("/courses/students/{courseId}")
    public List<Student> getStudentsInCourse(@PathVariable int courseId) {
        return courseService.getStudentsInCourse(courseId);
    }

    @GetMapping("/viewEnrolledCourses/{studentId}")
    public List<Course> viewEnrolledCourses(@PathVariable int studentId) {
        List<Course> theCourses = courseService.viewEnrolledCourses(studentId);
        return theCourses;
    }

}
