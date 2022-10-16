package com.studentmanagementsystem.springboot.app.facade;

import com.studentmanagementsystem.springboot.app.dto.AssignmentSubmissionDTO;

import java.util.List;

public interface AssignmentSubmissionFacade {
    public void add(AssignmentSubmissionDTO assignmentSubmissionDTO);

    public void deleteById(int id);

    public List<AssignmentSubmissionDTO> findAll();

    public AssignmentSubmissionDTO findById(int id);
}
