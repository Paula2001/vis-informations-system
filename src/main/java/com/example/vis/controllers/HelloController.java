package com.example.vis.controllers;


import java.io.PrintWriter;
import java.io.IOException;
import com.example.vis.models.AdminModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AdminModel x = new AdminModel();
//        PrintWriter writer = response.getWriter();
//        writer.println(x.getAll().get(0).getEmail());
        request.setAttribute("email", x.getAll().get(0).getEmail());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        out.println("this is post");
    }
}