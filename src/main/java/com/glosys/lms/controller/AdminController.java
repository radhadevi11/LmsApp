package com.glosys.lms.controller;

import service.AdminService;

public class AdminController {
    private static AdminService adminService = new AdminService();

    public boolean isValidAdmin(String name, String password){
        return adminService.isValidAdmin(name, password) ;
    }
}
