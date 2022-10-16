package com.studentmanagementsystem.springboot.app.dto;

import com.studentmanagementsystem.springboot.app.entity.Assignment;

import java.util.Date;

public class AssignmentDTO {

    private int id;

    private String description;

    private int courseId;

    private Date dueDate;

    public AssignmentDTO() {
    }

    public AssignmentDTO(Assignment assignment) {
        this.id = assignment.getId();
        this.description = assignment.getDescription();
        this.courseId = assignment.getCourse().getId();
        this.dueDate = assignment.getDueDate();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}

