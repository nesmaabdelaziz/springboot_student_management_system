package com.studentmanagementsystem.springboot.app.controller;

import java.util.List;

import com.studentmanagementsystem.springboot.app.entity.Student;
import com.studentmanagementsystem.springboot.app.service.StudentService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService theStudentService) {
        studentService = theStudentService;
    }

    // add mapping for "/list"

    @GetMapping("/list")
    public List<Student> listStudents(Model theModel) {
        // get employees from db
        List<Student> theStudents = studentService.findAll();
        return theStudents;
    }

    @GetMapping("/{studentId}")
    public Student getCustomer(@PathVariable int studentId) {
        Student theStudent = studentService.findById(studentId);
        if (theStudent == null) {
//            throw new StudentNotFoundException("Student id not found - " + studentId);
            System.out.println("Student id not found - " + studentId);
        }
        return theStudent;
    }


    @PostMapping("/newStudent")
    public Student addCustomer(@RequestBody Student theStudent) {
        // also just in case the pass an id in JSON ... set id to 0
        // this is force a save of new item ... instead of update
        theStudent.setId(0);
        studentService.save(theStudent);
        return theStudent;
    }

    @PutMapping("/newStudent")
    public Student updateStudent(@RequestBody Student theStudent) {
        studentService.save(theStudent);
        return theStudent;
    }

    @DeleteMapping("/{studentId}")
    public String deleteStudent(@PathVariable int studentId) {
        Student tempStudent = studentService.findById(studentId);
        if (tempStudent == null) {
            System.out.println("Student id not found - " + studentId);
        }
        studentService.deleteById(studentId);
        return "Deleted customer id - " + studentId;
    }
}
