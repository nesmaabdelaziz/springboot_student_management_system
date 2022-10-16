package com.studentmanagementsystem.springboot.app.controller;

    import com.studentmanagementsystem.springboot.app.entity.Admin;
import com.studentmanagementsystem.springboot.app.service.AdminService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admins")
public class AdminController {
    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    @GetMapping("/list")
    public List<Admin> listAdmins(Model theModel) {
        List<Admin> theAdmins = adminService.findAll();
        return theAdmins;
    }

    @GetMapping("/{adminId}")
    public Admin getAdmin(@PathVariable int adminId) {
        Admin theAdmin = adminService.findById(adminId);
        if (theAdmin == null) {
            System.out.println("Admin id not found - " + adminId);
        }
        return theAdmin;
    }


    @PostMapping("/newAdmin")
    public Admin addAdmin (@RequestBody Admin theAdmin) {
        theAdmin.setId(0);
        adminService.save(theAdmin);
        return theAdmin;
    }


    @PutMapping("/newAdmin")
    public Admin updateAdmin(@RequestBody Admin theAdmin) {
        adminService.save(theAdmin);
        return theAdmin;
    }

    @DeleteMapping("/{adminId}")
    public String deleteAdmin(@PathVariable int adminId) {
        Admin tempAdmin = adminService.findById(adminId);
        if (tempAdmin == null) {
            System.out.println("Admin id not found - " + adminId);
        }
        adminService.deleteById(adminId);
        return "Deleted Admin id - " + adminId;
    }

}
