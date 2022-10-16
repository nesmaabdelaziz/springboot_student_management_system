package com.studentmanagementsystem.springboot.app.service;

import com.studentmanagementsystem.springboot.app.entity.Admin;

import java.util.List;

public interface AdminService {
    public List<Admin> findAll();

    public Admin findById(int adminId);

    public void save(Admin theAdmin);

    public void deleteById(int adminId);

}
