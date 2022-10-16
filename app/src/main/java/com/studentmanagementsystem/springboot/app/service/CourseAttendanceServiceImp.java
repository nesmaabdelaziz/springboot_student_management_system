package com.studentmanagementsystem.springboot.app.service;

import com.studentmanagementsystem.springboot.app.dao.CourseAttendanceDAO;
import com.studentmanagementsystem.springboot.app.entity.CourseAttendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseAttendanceServiceImp implements CourseAttendanceService {

    private CourseAttendanceDAO courseAttendanceDAO;

    @Autowired
    public CourseAttendanceServiceImp(CourseAttendanceDAO courseAttendanceDAO) {
        this.courseAttendanceDAO = courseAttendanceDAO;
    }

    @Override
    public void save(CourseAttendance courseAttendance) {
        courseAttendanceDAO.save(courseAttendance);
    }

    @Override
    public void saveAll(List<CourseAttendance> courseAttendances) {
        courseAttendanceDAO.saveAll(courseAttendances);
    }

    @Override
    public void deleteById(int id) {
        courseAttendanceDAO.deleteById(id);
    }

    @Override
    public List<CourseAttendance> findAll() {
        return courseAttendanceDAO.findAll();
    }

    @Override
    public CourseAttendance findById(int id) {
        Optional<CourseAttendance> result = courseAttendanceDAO.findById(id);
        return result.orElse(null);
    }
    @Override
    public void submitStudentsAttendance(List<CourseAttendance> courseAttendances) {
        for (CourseAttendance courseAttendance:
                courseAttendances) {
            courseAttendance.setId(0);
            courseAttendanceDAO.save(courseAttendance);
        }
    }
}