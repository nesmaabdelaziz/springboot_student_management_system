package com.studentmanagementsystem.springboot.app.facade;

import com.studentmanagementsystem.springboot.app.dto.CourseDTO;
import com.studentmanagementsystem.springboot.app.entity.Course;
import com.studentmanagementsystem.springboot.app.entity.Student;
import com.studentmanagementsystem.springboot.app.entity.Teacher;
import com.studentmanagementsystem.springboot.app.service.CourseService;
import com.studentmanagementsystem.springboot.app.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseFacadeImp implements CourseFacade{

    private CourseService courseService;
    private TeacherService teacherService;

    @Autowired
    public CourseFacadeImp(CourseService courseService, TeacherService teacherService) {
        this.courseService = courseService;
        this.teacherService = teacherService;
    }

    @Override
    public void save(CourseDTO courseDTO) {
        Course course = convertToEntity(courseDTO);
        courseService.save(course);
        courseDTO.setId(course.getId());
    }

    @Override
    public void deleteById(int id) {
        Course course = courseService.findById(id);

        if(course == null) {
            throw new RuntimeException("Course id not found - " + id);
        }

        courseService.deleteById(id);
    }

    @Override
    public List<CourseDTO> findAll() {
        List<Course> courses =  courseService.findAll();
        List<CourseDTO> courseDTOList =new ArrayList<>();
        for (Course course:
                courses) {
            courseDTOList.add(convertToDto(course));

        }
        return  courseDTOList;
    }

    @Override
    public CourseDTO findById(int id) {
        Course course = courseService.findById(id);

        if(course == null) {
            throw new RuntimeException("Course id not found - " + id);
        }

        return convertToDto(course);
    }

    @Override
    public List<Student> getStudentsInCourse(int courseId) {
        return courseService.getStudentsInCourse(courseId);
    }

    @Override
    public List<CourseDTO> viewEnrolledCourses(int studentId) {
        List<Course> courses =  courseService.findAll();
        List<CourseDTO> courseDTOList =new ArrayList<>();
        for (Course course:
                courses) {
            courseDTOList.add(convertToDto(course));

        }
        return  courseDTOList;

    }

    private Course convertToEntity(CourseDTO courseDTO) {

        Teacher teacher = teacherService.findById(courseDTO.getTeacherId());

        if(teacher == null) {
            throw new RuntimeException("Teacher id not found - " + courseDTO.getTeacherId());
        }

        Course course = new Course(courseDTO);
        course.setTeacher(teacher);

        return course;
    }
    private CourseDTO convertToDto(Course course) {
        return new CourseDTO(course);
    }


}
