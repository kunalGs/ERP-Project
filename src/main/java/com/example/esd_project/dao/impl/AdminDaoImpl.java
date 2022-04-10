package com.example.esd_project.dao.impl;

import com.example.esd_project.bean.Admin;
import com.example.esd_project.bean.Courses;
import com.example.esd_project.dao.AdminDao;
import com.example.esd_project.util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class AdminDaoImpl implements AdminDao {
    @Override
    public boolean login(Admin admin) {
        try (Session session = HibernateSessionUtil.getSession();){
            Query q = session.createQuery("from Admin where username=:user and password=:pass");
            q.setParameter("user", admin.getUsername());
            q.setParameter("pass", admin.getPassword());
            if(q.getResultList().size()==1)
                return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
        return false;
    }
}
