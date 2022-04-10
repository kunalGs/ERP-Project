package com.example.esd_project.service;

import com.example.esd_project.bean.Employees;
import com.example.esd_project.dao.EmployeesDao;
import com.example.esd_project.dao.impl.EmployeesDaoImpl;

import java.util.List;

public class EmployeesService {
    EmployeesDao employeesDao = new EmployeesDaoImpl();
    public boolean addEmployee(Employees employees){
        return employeesDao.addEmployee(employees);
    }
    public List<Employees> getEmployees(){
        return employeesDao.getEmployees();
    }
    public Employees getEmployeeByID(int id){
        return employeesDao.getEmployeeByID(id);
    }
}
