package com.example.vis.controllers;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(name="hello",urlPatterns={"/hello"})

public class HelloController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        String connectionUrl = "jdbc:sqlserver://dbsys.cs.vsb.cz;databaseName=dbsql;user=GOR0096;password=N2ifO78so89893My;encrypt=false;";
//        try {
//            Connection con = DriverManager.getConnection(connectionUrl);
//            System.out.println(con);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        PrintWriter out = response.getWriter();
        out.println("this is a test hellllo");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        out.println("this is post");
    }
}