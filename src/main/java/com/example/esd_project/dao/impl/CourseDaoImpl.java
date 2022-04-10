package com.example.esd_project.dao.impl;

import com.example.esd_project.bean.Courses;
import com.example.esd_project.dao.CourseDao;
import com.example.esd_project.util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao {
    @Override
    public boolean addCourse(Courses course) {
        try (Session session = HibernateSessionUtil.getSession();) {
            System.out.println("in add course Try");
            Transaction transaction = session.beginTransaction();
            session.save(course);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.println("add course exception error");
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public List<Courses> getCourse() {
        List<Courses> courseList = new ArrayList<>();
        try (Session session = HibernateSessionUtil.getSession();){
            Transaction transaction = session.beginTransaction();
            for (final Object course : session.createQuery("from Courses ").list()) {
                courseList.add((Courses) course);
            }
            transaction.commit();
        } catch (HibernateException exception) {
            exception.printStackTrace();
        }
        return courseList;
    }

    @Override
    public boolean deleteCourseById(Courses course) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            Query q1 = session.createQuery("from Courses where course_id=:id");
            q1.setParameter("id", course.getCapacity());
            List<Courses> listResult = q1.list();
            System.out.println(listResult.get(0).getCourse_name());

            Query q = session.createQuery("delete Courses where course_id=:id or prerequisite=:code");
            q.setParameter("id", course.getCapacity()); //used capacity because id is auto generative
            q.setParameter("code", listResult.get(0).getCourse_code());
            q.executeUpdate();
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public boolean updateCourseCapacity(Courses course) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            Query q1 = session.createQuery("from Courses where course_id=:id");
            q1.setParameter("id", course.getCredit());
            if(q1.getResultList().size()<1) {
                System.out.println("here");
                return false;
            }
            Query q = session.createQuery("update Courses set capacity=:new_capacity where course_id=:id");
            q.setParameter("new_capacity", course.getCapacity());
            q.setParameter("id",course.getCredit());
            q.executeUpdate();
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }
}
