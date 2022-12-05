package com.example.vis.controllers;

import com.example.vis.database.DatabaseConnection;
import com.example.vis.database.SQLConnection;
import jakarta.servlet.http.HttpServlet;

import java.sql.Connection;

public class Controller extends HttpServlet {
    protected static final DatabaseConnection<Connection> DATABASE_CONNECTION = new SQLConnection();

}
