package com.example.vis.controllers;


import java.sql.ResultSet;
import java.io.PrintWriter;
import java.io.IOException;
import com.example.vis.models.AdminModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloController extends Controller{

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AdminModel x = new AdminModel();
        PrintWriter writer = response.getWriter();
        writer.println(x.getAll().get(0).getEmail());
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        out.println("this is post");
    }
}