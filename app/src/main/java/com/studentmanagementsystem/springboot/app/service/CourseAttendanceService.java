package com.studentmanagementsystem.springboot.app.service;

import com.studentmanagementsystem.springboot.app.entity.CourseAttendance;

import java.util.List;

public interface CourseAttendanceService {

    public void save(CourseAttendance courseAttendance);

    public void saveAll(List<CourseAttendance> courseAttendances);

    public void deleteById(int id);

    public List<CourseAttendance> findAll();

    public CourseAttendance findById(int id);
    public void submitStudentsAttendance(List<CourseAttendance> courseAttendances);

}