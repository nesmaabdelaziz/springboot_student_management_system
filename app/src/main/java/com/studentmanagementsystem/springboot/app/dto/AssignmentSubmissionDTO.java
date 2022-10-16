package com.studentmanagementsystem.springboot.app.dto;

import com.studentmanagementsystem.springboot.app.entity.AssignmentSubmission;

import java.util.Date;

public class AssignmentSubmissionDTO {
    private int id;

    private int studentId;

    private int assignmentId;

    private int CourseId;

    private Date submissionDate;

    private String content;

    private int marks;

    public AssignmentSubmissionDTO() {
    }

    public AssignmentSubmissionDTO(AssignmentSubmission assignmentSubmission) {
        this.id = assignmentSubmission.getId();
        this.studentId = assignmentSubmission.getStudent().getId();
        this.assignmentId = assignmentSubmission.getAssignment().getId();
        this.CourseId = assignmentSubmission.getCourse().getId();
        this.submissionDate = assignmentSubmission.getLocal_date();
        this.content = assignmentSubmission.getContent();
        this.marks = assignmentSubmission.getMarks();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return CourseId;
    }

    public void setCourseId(int courseId) {
        CourseId = courseId;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int mark) {
        this.marks = mark;
    }

    public static AssignmentSubmissionDTO convertToDTO(AssignmentSubmission assignmentSubmission) {
        return new AssignmentSubmissionDTO(assignmentSubmission);
    }
}
