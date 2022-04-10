package com.example.esd_project.dao;

import com.example.esd_project.bean.Employees;

import java.util.List;

public interface EmployeesDao {
    boolean addEmployee(Employees emp);
    List<Employees> getEmployees();
    Employees getEmployeeByID (int id);
}