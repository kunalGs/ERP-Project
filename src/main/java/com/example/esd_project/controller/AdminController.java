package com.example.esd_project.controller;

import com.example.esd_project.bean.Admin;
import com.example.esd_project.service.AdminService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("admin")
public class AdminController {
    AdminService adminService = new AdminService();

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response loginService(Admin admin){
        System.out.println("****************in get login Service******************88");
        if(adminService.loginService(admin))
            return Response.ok().build();
        return Response.status(203).build();
    }
}
