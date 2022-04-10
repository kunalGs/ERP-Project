package com.example.esd_project.service;

import com.example.esd_project.bean.Admin;
import com.example.esd_project.dao.AdminDao;
import com.example.esd_project.dao.impl.AdminDaoImpl;

public class AdminService {
    AdminDao adminDao = new AdminDaoImpl();
    public boolean loginService(Admin admin){
        return adminDao.login(admin);
    }


}
