package com.studentmanagementsystem.springboot.app.dao;


import com.studentmanagementsystem.springboot.app.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDAO extends JpaRepository<Admin, Integer> {

}
