package com.example.esd_project.dao;

import com.example.esd_project.bean.Courses;

import java.util.List;

public interface CourseDao {
    boolean addCourse(Courses course);
    List<Courses> getCourse();
    boolean deleteCourseById(Courses course);
    boolean updateCourseCapacity(Courses course);
}
