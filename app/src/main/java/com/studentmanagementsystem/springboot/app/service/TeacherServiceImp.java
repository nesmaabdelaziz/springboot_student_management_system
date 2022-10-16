package com.studentmanagementsystem.springboot.app.service;

import com.studentmanagementsystem.springboot.app.dao.TeacherDAO;
import com.studentmanagementsystem.springboot.app.entity.Teacher;
import com.studentmanagementsystem.springboot.app.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImp implements TeacherService{
    private TeacherDAO teacherDAO;

    @Autowired
    public TeacherServiceImp(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherDAO.findAll();
    }

    @Override
    public Teacher findById(int theId) {
        Optional<Teacher> result = teacherDAO.findById(theId);

        Teacher theTeacher = null;

        if (result.isPresent()) {
            theTeacher = result.get();
        }
        else {
            throw new NotFoundException("Did not find teacher id - " + theId);
        }

        return theTeacher;
    }

    @Override
    public void save(Teacher theTeacher) {
        teacherDAO.save(theTeacher);

    }

    @Override
    public void deleteById(int theId) {
        teacherDAO.deleteById(theId);
    }

}
