package com.studentmanagementsystem.springboot.app.facade;

import com.studentmanagementsystem.springboot.app.dto.AssignmentDTO;

import java.util.List;

public interface AssignmentFacade {
    public void save(AssignmentDTO assignmentDTO);

    public void deleteById(int id);

    public List<AssignmentDTO> findAll();

    public AssignmentDTO findById(int id);
    public List<AssignmentDTO> getAssignmentsInCourse(int courseId);
}
