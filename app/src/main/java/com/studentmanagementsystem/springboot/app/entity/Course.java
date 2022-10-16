package com.studentmanagementsystem.springboot.app.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.studentmanagementsystem.springboot.app.dto.CourseDTO;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="course")
public class Course {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    //to remove the dto
    //private int teacherId;

    @ManyToMany
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(
                    name = "course_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id"
            )
    )
    @JsonIgnore
    private  List<Student> students;

    @Column(name="name")
    private String name;

    @ManyToOne()
    @JoinColumn(name="teacher_id")
    private Teacher teacher;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private List<Assignment> assignments;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private List<CourseAttendance> courseAttendences;


    public Course() {
    }

    public Course(String name) {
        this.name = name;

    }

    public Course(CourseDTO courseDTO)
    {
        this.id = courseDTO.getId();
        this.name = courseDTO.getName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<CourseAttendance> getCourseAttendences() {
        return courseAttendences;
    }

    public void setCourseAttendences(List<CourseAttendance> courseAttendences) {
        this.courseAttendences = courseAttendences;
    }


    @Override
    public String toString() {
        return "course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}











