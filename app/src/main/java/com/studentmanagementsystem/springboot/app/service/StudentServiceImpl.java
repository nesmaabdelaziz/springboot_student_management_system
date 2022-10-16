package com.studentmanagementsystem.springboot.app.service;

import com.studentmanagementsystem.springboot.app.dao.StudentDAO;
import com.studentmanagementsystem.springboot.app.entity.Student;
import com.studentmanagementsystem.springboot.app.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentDAO studentDAO;


    @Autowired
    public StudentServiceImpl(StudentDAO theStudentDAO) {
        this.studentDAO = theStudentDAO;

    }

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public Student findById(int theId) {
        Optional<Student> result = studentDAO.findById(theId);

        Student theStudent = null;

        if (result.isPresent()) {
            theStudent = result.get();
        }
        else {
            throw new NotFoundException("Did not find student id - " + theId);
        }

        return theStudent;
    }

    @Override
    public void save(Student theStudent) {
        studentDAO.save(theStudent);

    }

    @Override
    public void deleteById(int theId) {
        studentDAO.deleteById(theId);
    }
    @Override
    public void enrollCourse(int studentId) {
//        studentRepository.deleteById(studentId);
    }

}

