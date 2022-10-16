package com.studentmanagementsystem.springboot.app.service;

import com.studentmanagementsystem.springboot.app.entity.Student;

import java.util.List;

public interface StudentService {

    public List<Student> findAll();

    public Student findById(int studentId);

    public void save(Student theStudent);

    public void deleteById(int studentId);

    public void enrollCourse(int studentId);

}
