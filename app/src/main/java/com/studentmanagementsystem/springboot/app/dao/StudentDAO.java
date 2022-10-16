package com.studentmanagementsystem.springboot.app.dao;

import com.studentmanagementsystem.springboot.app.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentDAO extends JpaRepository<Student, Integer> {

}
