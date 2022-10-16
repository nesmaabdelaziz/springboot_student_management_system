package com.studentmanagementsystem.springboot.app.service;

import com.studentmanagementsystem.springboot.app.entity.Teacher;

import java.util.List;

public interface TeacherService {
    ///////////////////////////////////////////
    public List<Teacher> findAll();

    public Teacher findById(int teacherId);

    public void save(Teacher theTeacher);

    public void deleteById(int teacherId);

}
