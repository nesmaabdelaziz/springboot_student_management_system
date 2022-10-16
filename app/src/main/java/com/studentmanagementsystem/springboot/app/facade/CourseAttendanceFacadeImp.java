package com.studentmanagementsystem.springboot.app.facade;

import com.studentmanagementsystem.springboot.app.dto.CourseAttendanceDTO;
import com.studentmanagementsystem.springboot.app.entity.Course;
import com.studentmanagementsystem.springboot.app.entity.CourseAttendance;
import com.studentmanagementsystem.springboot.app.entity.Student;
import com.studentmanagementsystem.springboot.app.service.CourseAttendanceService;
import com.studentmanagementsystem.springboot.app.service.CourseService;
import com.studentmanagementsystem.springboot.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseAttendanceFacadeImp implements CourseAttendanceFacade {
    private CourseService courseService;
    private StudentService studentService;
    private CourseAttendanceService courseAttendanceService;


    @Autowired
    public CourseAttendanceFacadeImp(CourseAttendanceService courseAttendanceService, CourseService courseService, StudentService studentService) {
        this.courseAttendanceService = courseAttendanceService;
        this.courseService = courseService;
        this.studentService = studentService;
    }

    @Override
    public void add(CourseAttendanceDTO courseAttendanceDTO) {
        CourseAttendance courseAttendance = convertToEntity(courseAttendanceDTO);
        courseAttendanceService.save(courseAttendance);
        courseAttendanceDTO.setId(courseAttendance.getId());
    }

    @Override
    public void addAll(List<CourseAttendanceDTO> courseAttendanceDTOList) {

        for (CourseAttendanceDTO courseAttendanceDTO:
                courseAttendanceDTOList) {
            CourseAttendance courseAttendance = convertToEntity(courseAttendanceDTO);
            courseAttendance.setId(0);
            courseAttendanceService.save(courseAttendance);
        }
    }


    @Override
    public void deleteById(int id) {
        CourseAttendance courseAttendance = courseAttendanceService.findById(id);

        if(courseAttendance == null) {
            throw new RuntimeException("CourseAttendance id not found - " + id);
        }

        courseAttendanceService.deleteById(id);
    }

    @Override
    public List<CourseAttendanceDTO> findAll() {
//
//        return courseAttendanceService.findAll().stream().map(CourseAttendanceDTO::convertToDTO)
//                .collect(Collectors.toList());
        List<CourseAttendance> courseAttendances =  courseAttendanceService.findAll();
        List<CourseAttendanceDTO> courseAttendanceDTOList =new ArrayList<>();
        for (CourseAttendance courseAttendance:
                courseAttendances) {
            courseAttendanceDTOList.add(convertToDTO(courseAttendance));
        }
        return  courseAttendanceDTOList;
    }

    @Override
    public CourseAttendanceDTO findById(int id) {
        CourseAttendance courseAttendance = courseAttendanceService.findById(id);

        if(courseAttendance == null) {
            throw new RuntimeException("CourseAttendance id not found - " + id);
        }

        return convertToDTO(courseAttendance);
    }

    public CourseAttendanceDTO convertToDTO(CourseAttendance courseAttendance) {
        return new CourseAttendanceDTO(courseAttendance);
    }


    private CourseAttendance convertToEntity(CourseAttendanceDTO courseAttendanceDTO) {

        Course course = courseService.findById(courseAttendanceDTO.getCourseId());

        if(course == null) {
            throw new RuntimeException("could not find Course with this id:  " + courseAttendanceDTO.getCourseId());
        }

        Student student = studentService.findById(courseAttendanceDTO.getStudentId());

        if(student == null) {
            throw new RuntimeException("could not find Student with this id: " + courseAttendanceDTO.getStudentId());
        }
        CourseAttendance courseAttendance = new CourseAttendance(courseAttendanceDTO);
        courseAttendance.setCourse(course);
        courseAttendance.setStudent(student);

        return courseAttendance;
    }
}
