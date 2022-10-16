package com.studentmanagementsystem.springboot.app.service;

import com.studentmanagementsystem.springboot.app.dao.AssignmentDAO;
import com.studentmanagementsystem.springboot.app.entity.Assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentServiceImp implements AssignmentService{
    private AssignmentDAO assignmentDAO;

    @Autowired
    public AssignmentServiceImp(AssignmentDAO assignmentDAO) {
        this.assignmentDAO = assignmentDAO;
    }

    @Override
    public void save(Assignment assignment) {
        assignmentDAO.save(assignment);
    }

    @Override
    public void deleteById(int id) {
        assignmentDAO.deleteById(id);
    }

    @Override
    public List<Assignment> findAll() {
        return assignmentDAO.findAll();
    }

    @Override
    public Assignment findById(int id) {
        Optional<Assignment> result = assignmentDAO.findById(id);
        return result.orElse(null);
    }
    @Override
    public List<Assignment> viewAssignments(int courseId) {
        return assignmentDAO.viewAssignments(courseId);
    }

}
