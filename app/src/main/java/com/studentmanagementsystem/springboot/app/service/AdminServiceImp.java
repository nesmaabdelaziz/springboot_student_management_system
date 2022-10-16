package com.studentmanagementsystem.springboot.app.service;

import com.studentmanagementsystem.springboot.app.dao.AdminDAO;
import com.studentmanagementsystem.springboot.app.dao.TeacherDAO;
import com.studentmanagementsystem.springboot.app.entity.Admin;
import com.studentmanagementsystem.springboot.app.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImp implements AdminService{
    private AdminDAO adminDAO;
    private TeacherDAO teacherDAO;

    @Autowired
    public AdminServiceImp(AdminDAO adminDAO, TeacherDAO teacherDAO) {
        this.adminDAO = adminDAO;
        this.teacherDAO = teacherDAO;
    }

    @Override
    public List<Admin> findAll() {
        return adminDAO.findAll();
    }

    @Override
    public Admin findById(int adminId) {
        Optional<Admin> result = adminDAO.findById(adminId);

        Admin theAdminId = null;

        if (result.isPresent()) {
            theAdminId = result.get();
        }
        else {
            throw new NotFoundException("Did not find admin id - " + adminId);
        }

        return theAdminId;
    }

    @Override
    public void save(Admin theAdmin) {
        adminDAO.save(theAdmin);
    }

    @Override
    public void deleteById(int adminId) {
        adminDAO.deleteById(adminId);
    }

}
