package com.studentmanagementsystem.springboot.app.service;

import com.studentmanagementsystem.springboot.app.entity.Assignment;

import java.util.List;

public interface AssignmentService {

    public void save(Assignment assignment);

    public void deleteById(int id);

    public List<Assignment> findAll();

    public Assignment findById(int id);

    public List<Assignment> viewAssignments(int courseId);
}
