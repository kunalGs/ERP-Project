package com.example.esd_project.controller;

import com.example.esd_project.bean.Courses;
import com.example.esd_project.service.CourseService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("course")
public class CourseController {
    CourseService courseService = new CourseService();

    @GET
    @Path("/getCourse")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCourseController(){
        System.out.println("****************in get Course Controller kunal*****************");
        List<Courses> courses = courseService.getCoursesService();
        System.out.println(courses);
        return Response.ok().entity(courses).build();
    }

    @POST
    @Path("/register")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCourse(Courses course){
        if(courseService.addCourseService(course))
            return Response.ok().build();
        return Response.status(203).build();
    }

    @POST
    @Path("/deleteCourse")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteCourse(Courses course){
        if(courseService.deleteCourseByIdService(course))
            return Response.ok().build();
        return Response.status(203).build();
    }

    @POST
    @Path("/updateCourse")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCourse(Courses course){
        if(courseService.updateCourseCapacityService(course))
            return Response.ok().build();
        return Response.status(203).build();
    }
}
