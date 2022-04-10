package com.example.esd_project.service;

import com.example.esd_project.bean.Courses;
import com.example.esd_project.bean.Employees;
import com.example.esd_project.dao.CourseDao;
import com.example.esd_project.dao.EmployeesDao;
import com.example.esd_project.dao.impl.CourseDaoImpl;
import com.example.esd_project.dao.impl.EmployeesDaoImpl;

import java.util.List;

public class CourseService {
    CourseDao courseDao = new CourseDaoImpl();
    public boolean addCourseService(Courses course) {
        return courseDao.addCourse(course);
    }

    public List<Courses> getCoursesService() {
        return courseDao.getCourse();
    }

    public boolean deleteCourseByIdService(Courses course){
        return courseDao.deleteCourseById(course);
    }

    public boolean updateCourseCapacityService(Courses course){
        return courseDao.updateCourseCapacity(course);
    }
}
