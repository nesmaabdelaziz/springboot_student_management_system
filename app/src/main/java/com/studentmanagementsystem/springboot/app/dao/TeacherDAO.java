package com.studentmanagementsystem.springboot.app.dao;

import com.studentmanagementsystem.springboot.app.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherDAO extends JpaRepository<Teacher, Integer> {

}
