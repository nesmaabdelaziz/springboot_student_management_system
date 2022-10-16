package com.studentmanagementsystem.springboot.app.service;

import com.studentmanagementsystem.springboot.app.entity.AssignmentSubmission;

import java.util.List;

public interface AssignmentSubmissionService {

    public void save(AssignmentSubmission assignmentSubmission);

    public void deleteById(int id);

    public List<AssignmentSubmission> findAll();

    public AssignmentSubmission findById(int id);
}