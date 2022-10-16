package com.studentmanagementsystem.springboot.app.dao;

import com.studentmanagementsystem.springboot.app.entity.CourseAttendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseAttendanceDAO extends JpaRepository<CourseAttendance, Integer> {

}
