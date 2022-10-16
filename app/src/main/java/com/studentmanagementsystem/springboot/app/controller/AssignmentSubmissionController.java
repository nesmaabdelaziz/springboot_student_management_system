//package com.mariam.springboot.studentsystem.controller;
//
//
//import com.mariam.springboot.studentsystem.entity.AssignmentSubmission;
//import com.mariam.springboot.studentsystem.entity.Student;
//import com.mariam.springboot.studentsystem.service.AssignmentSubmissionService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/assignmentSubmissions")
//public class AssignmentSubmissionController {
//    private AssignmentSubmissionService assignmentSubmissionService;
//
//    @Autowired
//    public AssignmentSubmissionController(AssignmentSubmissionService assignmentSubmissionService) {
//        this.assignmentSubmissionService = assignmentSubmissionService;
//    }
//
//
//    @GetMapping("/list")
//    public List<AssignmentSubmission> viewAllAssignmentSubmissions() {
//        return assignmentSubmissionService.findAll();
//    }
//
//    @GetMapping("/{assignmentSubmissionId}")
//    public AssignmentSubmission getAssignmentSubmission(@PathVariable int assignmentSubmissionId) {
//        AssignmentSubmission assignmentSubmission = assignmentSubmissionService.findById(assignmentSubmissionId);
//
//        if(assignmentSubmission == null) {
//            throw new RuntimeException("AssignmentSubmission id not found - " + assignmentSubmissionId);
//        }
//
//        return assignmentSubmission;
//    }
//
//    @PostMapping("/newAssignmentSubmissions")
//    public AssignmentSubmission addAssignmentSubmission(@RequestBody AssignmentSubmission assignmentSubmission) {
//
//        assignmentSubmission.setId(0);
////        Student student=new Student();
////        student.setId(1);
////        assignmentSubmission.setStudent(student);
//        assignmentSubmissionService.save(assignmentSubmission);
//        return assignmentSubmission;
//    }
//
//    @PutMapping("/newAssignmentSubmissions")
//    public AssignmentSubmission updateAssignmentSubmission(@RequestBody AssignmentSubmission assignmentSubmission) {
//        assignmentSubmissionService.save(assignmentSubmission);
//        return assignmentSubmission;
//    }
//
//    @DeleteMapping("/{assignmentSubmissionId}")
//    public String removeAssignmentSubmission(@PathVariable int assignmentSubmissionId) {
//        AssignmentSubmission assignmentSubmission = assignmentSubmissionService.findById(assignmentSubmissionId);
//
//        if(assignmentSubmission == null) {
//            throw new RuntimeException("AssignmentSubmission id not found - " + assignmentSubmissionId);
//        }
//
//        assignmentSubmissionService.deleteById(assignmentSubmissionId);
//
//        return "Deleted AssignmentSubmission id - " + assignmentSubmissionId;
//    }
//}
package com.studentmanagementsystem.springboot.app.controller;

import com.studentmanagementsystem.springboot.app.dto.AssignmentSubmissionDTO;
import com.studentmanagementsystem.springboot.app.entity.Assignment;
import com.studentmanagementsystem.springboot.app.entity.AssignmentSubmission;
import com.studentmanagementsystem.springboot.app.entity.Course;
import com.studentmanagementsystem.springboot.app.entity.Student;
import com.studentmanagementsystem.springboot.app.service.AssignmentSubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssignmentSubmissionController {
    private AssignmentSubmissionService assignmentSubmissionService;

    @Autowired
    public AssignmentSubmissionController(AssignmentSubmissionService assignmentSubmissionService) {
        this.assignmentSubmissionService = assignmentSubmissionService;
    }

    @GetMapping("/assignmentSubmissions")
    public List<AssignmentSubmission> viewAllAssignmentSubmissions() {
        return assignmentSubmissionService.findAll();
    }

    @GetMapping("/assignmentSubmissions/{assignmentSubmissionId}")
    public AssignmentSubmission getAssignmentSubmission(@PathVariable int assignmentSubmissionId) {
        AssignmentSubmission assignmentSubmission = assignmentSubmissionService.findById(assignmentSubmissionId);
        return assignmentSubmission;
    }

    @PostMapping("/assignmentSubmissions")
    public AssignmentSubmission addAssignmentSubmission(@RequestBody AssignmentSubmissionDTO assignmentSubmissionDTO) {
        assignmentSubmissionDTO.setId(0);
        AssignmentSubmission assignmentSubmission = new AssignmentSubmission();
        assignmentSubmission.setId(assignmentSubmissionDTO.getId());
        assignmentSubmission.setContent(assignmentSubmissionDTO.getContent());
        assignmentSubmission.setMarks(assignmentSubmissionDTO.getMarks());
        assignmentSubmission.setLocal_date(assignmentSubmissionDTO.getSubmissionDate());

        Assignment assignment = new Assignment();
        assignment.setId(assignmentSubmissionDTO.getAssignmentId());

        Student student = new Student();
        student.setId(assignmentSubmissionDTO.getStudentId());

        Course course = new Course();
        course.setId(assignmentSubmissionDTO.getCourseId());

        assignmentSubmission.setAssignment(assignment);
        assignmentSubmission.setStudent(student);
        assignmentSubmission.setCourse(course);

        assignmentSubmissionService.save(assignmentSubmission);
        return assignmentSubmission;
    }

    @PutMapping("/assignmentSubmissions")
    public AssignmentSubmission updateAssignmentSubmission(@RequestBody AssignmentSubmissionDTO assignmentSubmissionDTO) {
        AssignmentSubmission assignmentSubmission = new AssignmentSubmission();
        assignmentSubmission.setId(assignmentSubmissionDTO.getId());
        assignmentSubmission.setContent(assignmentSubmissionDTO.getContent());
        assignmentSubmission.setMarks(assignmentSubmissionDTO.getMarks());
        assignmentSubmission.setLocal_date(assignmentSubmissionDTO.getSubmissionDate());

        Assignment assignment = new Assignment();
        assignment.setId(assignmentSubmissionDTO.getAssignmentId());

        Student student = new Student();
        student.setId(assignmentSubmissionDTO.getStudentId());

        Course course = new Course();
        course.setId(assignmentSubmissionDTO.getCourseId());

        assignmentSubmission.setAssignment(assignment);
        assignmentSubmission.setStudent(student);
        assignmentSubmission.setCourse(course);

        assignmentSubmissionService.save(assignmentSubmission);
        return assignmentSubmission;
    }

    @DeleteMapping("/assignmentSubmissions/{assignmentSubmissionId}")
    public String removeAssignmentSubmission(@PathVariable int assignmentSubmissionId) {
        assignmentSubmissionService.deleteById(assignmentSubmissionId);
        return "Deleted AssignmentSubmission id - " + assignmentSubmissionId;
    }
}
