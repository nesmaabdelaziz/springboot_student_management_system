package com.studentmanagementsystem.springboot.app.dao;

import com.studentmanagementsystem.springboot.app.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AssignmentDAO extends JpaRepository<Assignment, Integer> {
    @Query(value="select a.* from course c, assignment a where c.id= a.course_id AND c.id = ?1", nativeQuery=true)
    public List<Assignment> viewAssignments(int courseId);
}
