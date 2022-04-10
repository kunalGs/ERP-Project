package com.example.esd_project.dao.impl;

import com.example.esd_project.bean.Employees;
import com.example.esd_project.dao.EmployeesDao;
import com.example.esd_project.util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class EmployeesDaoImpl implements EmployeesDao {
    @Override
    public boolean addEmployee(Employees emp) {
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction t = session.beginTransaction();
            session.save(emp);
            t.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public List<Employees> getEmployees() {

        List<Employees> employeesList = new ArrayList<>();
        try (Session session = HibernateSessionUtil.getSession();){
            for (final Object employee : session.createQuery("from Employees ").list()) {
                employeesList.add((Employees) employee);
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return employeesList;
    }

    @Override
    public Employees getEmployeeByID(int id) {
        try (Session session = HibernateSessionUtil.getSession()) {
            return session.get(Employees.class, id);
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }
}