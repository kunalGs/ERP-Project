package com.example.esd_project.service;

import com.example.esd_project.bean.Departments;
import com.example.esd_project.dao.DepartmentDao;
import com.example.esd_project.dao.impl.DepartmentDaoImpl;

public class DepartmentService {
    DepartmentDao departmentDao= new DepartmentDaoImpl();
    public boolean addDepartment(Departments departments){
        return departmentDao.addDepartment(departments);
    }
}
