package com.studentmanagementsystem.springboot.app.controller;

import com.studentmanagementsystem.springboot.app.dto.CourseAttendanceDTO;
import com.studentmanagementsystem.springboot.app.facade.CourseAttendanceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/courseAttendances")
public class CourseAttendanceController {

private CourseAttendanceFacade courseAttendanceFacade;

    @Autowired
    public CourseAttendanceController(CourseAttendanceFacade courseAttendanceFacade) {
        this.courseAttendanceFacade = courseAttendanceFacade;
    }


    @GetMapping("/list")
    public List<CourseAttendanceDTO> viewAllCourseAttendances() {
        return courseAttendanceFacade.findAll();
    }

    @GetMapping("/list/{courseAttendanceId}")
    public CourseAttendanceDTO getCourseAttendance(@PathVariable int courseAttendanceId) {
        return courseAttendanceFacade.findById(courseAttendanceId);
    }

    @PostMapping("/newCourseAttendances")
    public CourseAttendanceDTO addCourseAttendance(@RequestBody CourseAttendanceDTO courseAttendanceDTO) {
        courseAttendanceDTO.setId(0);
        courseAttendanceFacade.add(courseAttendanceDTO);
        return courseAttendanceDTO;
    }

    @PutMapping("/newCourseAttendances")
    public CourseAttendanceDTO updateCourseAttendance(@RequestBody CourseAttendanceDTO courseAttendanceDTO) {
        courseAttendanceFacade.add(courseAttendanceDTO);
        return courseAttendanceDTO;
    }

    @DeleteMapping("/{courseAttendanceId}")
    public String removeCourseAttendance(@PathVariable int courseAttendanceId) {
        courseAttendanceFacade.deleteById(courseAttendanceId);
        return "Deleted CourseAttendance id - " + courseAttendanceId;
    }

    @PostMapping("/submitAll")
    public List<CourseAttendanceDTO> submitStudentsAttendance(@RequestBody List<CourseAttendanceDTO> courseAttendanceDTOs) {

        courseAttendanceFacade.addAll(
                courseAttendanceDTOs
        );

        return courseAttendanceDTOs;
    }
}