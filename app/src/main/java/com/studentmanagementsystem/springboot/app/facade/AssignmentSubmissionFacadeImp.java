package com.studentmanagementsystem.springboot.app.facade;

import com.studentmanagementsystem.springboot.app.dto.AssignmentSubmissionDTO;
import com.studentmanagementsystem.springboot.app.entity.Assignment;
import com.studentmanagementsystem.springboot.app.entity.AssignmentSubmission;
import com.studentmanagementsystem.springboot.app.entity.Student;
import com.studentmanagementsystem.springboot.app.service.AssignmentService;
import com.studentmanagementsystem.springboot.app.service.AssignmentSubmissionService;
import com.studentmanagementsystem.springboot.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssignmentSubmissionFacadeImp implements AssignmentSubmissionFacade{
    private AssignmentSubmissionService assignmentSubmissionService;
    private StudentService studentService;
    private AssignmentService assignmentService;

    @Autowired
    public AssignmentSubmissionFacadeImp(AssignmentSubmissionService assignmentSubmissionService,  StudentService studentService, AssignmentService assignmentService) {
        this.assignmentSubmissionService = assignmentSubmissionService;
        this.studentService = studentService;
        this.assignmentService = assignmentService;
    }


    @Override
    public void add(AssignmentSubmissionDTO assignmentSubmissionDTO) {
        AssignmentSubmission assignmentSubmission = convertToEntity(assignmentSubmissionDTO);
        assignmentSubmissionService.save(assignmentSubmission);
        assignmentSubmissionDTO.setId(assignmentSubmission.getId());
    }



    @Override
    public void deleteById(int id) {
        AssignmentSubmission assignmentSubmission = assignmentSubmissionService.findById(id);

        if(assignmentSubmission == null) {
            throw new RuntimeException("AssignmentSubmission id not found - " + id);
        }

        assignmentSubmissionService.deleteById(id);
    }

    @Override
    public List<AssignmentSubmissionDTO> findAll() {
        List<AssignmentSubmission> assignments =  assignmentSubmissionService.findAll();
        List<AssignmentSubmissionDTO> assignmentDTOList =new ArrayList<>();
        for (AssignmentSubmission assignment:
                assignments) {
            assignmentDTOList.add(convertToDto(assignment));
        }
        return  assignmentDTOList;
    }

    @Override
    public AssignmentSubmissionDTO findById(int id) {
        AssignmentSubmission assignmentSubmission = assignmentSubmissionService.findById(id);

        if(assignmentSubmission == null) {
            throw new RuntimeException("No Assignment with this id found: " + id);
        }

        return convertToDto(assignmentSubmission);
    }
    private AssignmentSubmissionDTO convertToDto(AssignmentSubmission assignmentSubmission) {
        return new AssignmentSubmissionDTO(assignmentSubmission);
    }
    private AssignmentSubmission convertToEntity(AssignmentSubmissionDTO assignmentSubmissionDTO) {
        Student student = studentService.findById(assignmentSubmissionDTO.getStudentId());
        if(student == null) {
            throw new RuntimeException("No Assignment with this id found: " + assignmentSubmissionDTO.getStudentId());
        }
        Assignment assignment = assignmentService.findById(assignmentSubmissionDTO.getAssignmentId());
        if(assignment == null) {
            throw new RuntimeException("No Assignment with this id found: " + assignmentSubmissionDTO.getAssignmentId());
        }

        AssignmentSubmission assignmentSubmission = new AssignmentSubmission(assignmentSubmissionDTO);
        assignmentSubmission.setStudent(student);
        assignmentSubmission.setAssignment(assignment);
        return assignmentSubmission;
    }
}
