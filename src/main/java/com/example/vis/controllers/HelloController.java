package com.example.vis.controllers;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class HelloController extends Controller{


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        try {

            Connection conn = DATABASE_CONNECTION.getConnection();

            System.out.println(conn);

            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM actor ;";
            ResultSet rs = statement.executeQuery(sql);
            int count = 1;
            while (rs.next()) {
                writer.println(String.format("User #%d: %-15s %s", count++,
                        rs.getString("first_name"), rs.getString("last_name")));

            }

        }
        catch (Exception e)
        {
            System.out.println("Connection Failed 😢");
            System.out.println(e);
        }

        PrintWriter out = response.getWriter();
        out.println("this is a test hellllo");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        out.println("this is post");
    }
}