package com.studentmanagementsystem.springboot.app.service;

import com.studentmanagementsystem.springboot.app.dao.AssignmentDAO;
import com.studentmanagementsystem.springboot.app.dao.AssignmentSubmissionDAO;
import com.studentmanagementsystem.springboot.app.dao.CourseDAO;
import com.studentmanagementsystem.springboot.app.dao.StudentDAO;
import com.studentmanagementsystem.springboot.app.entity.*;
import com.studentmanagementsystem.springboot.app.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentSubmissionServiceImp implements AssignmentSubmissionService{
    private AssignmentSubmissionDAO assignmentSubmissionDAO;
    private AssignmentDAO assignmentDAO;
    private StudentDAO studentDAO;
    private CourseDAO courseDAO;

    @Autowired
    public AssignmentSubmissionServiceImp(AssignmentSubmissionDAO assignmentSubmissionDAO, AssignmentDAO assignmentDAO, StudentDAO studentDAO, CourseDAO courseDAO) {
        this.studentDAO = studentDAO;
        this.assignmentDAO = assignmentDAO;
        this.courseDAO = courseDAO;
        this.assignmentSubmissionDAO = assignmentSubmissionDAO;
    }

    @Override
    public void save(AssignmentSubmission assignmentSubmission) {
        Assignment assignment = assignmentDAO.findById(assignmentSubmission.getAssignment().getId()).orElseThrow(()->new NotFoundException("not found"));
        Student student = studentDAO.findById(assignmentSubmission.getStudent().getId()).orElseThrow(()->new NotFoundException("not found"));
        Course course = courseDAO.findById(assignmentSubmission.getCourse().getId()).orElseThrow(()->new NotFoundException("not found"));
        assignmentSubmissionDAO.save(assignmentSubmission);
    }

    @Override
    public void deleteById(int id) {
        AssignmentSubmission assignmentSubmission = assignmentSubmissionDAO.findById(id).orElseThrow(()->new NotFoundException("not found"));
        assignmentSubmissionDAO.deleteById(id);
    }

    @Override
    public List<AssignmentSubmission> findAll() {
        return assignmentSubmissionDAO.findAll();
    }

    @Override
    public AssignmentSubmission findById(int id) {
        AssignmentSubmission assignmentSubmission = assignmentSubmissionDAO.findById(id).orElseThrow(()->new NotFoundException("not found"));
        return assignmentSubmission;
    }

}