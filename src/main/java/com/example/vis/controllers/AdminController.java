package com.example.vis.controllers;


import com.example.vis.models.AdminModel;
import jakarta.enterprise.context.SessionScoped;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.desktop.UserSessionEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AdminController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AdminModel x = new AdminModel();
//        PrintWriter writer = response.getWriter();
//        writer.println(x.getAll().get(0).getEmail());
        request.setAttribute("email", x.getAll().get(0).getEmail());
        request.getRequestDispatcher("admin-login.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        AdminModel admin = new AdminModel();
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (getMd5(password).equals(admin.where("where email = " + "'" + email + "'").get(0).getPassword())) { // TODO : lovely SQL injection <3
            req.getSession().setAttribute("isLoggedInAdmin", "true");
            resp.setStatus(200);
            return;
        }
        resp.setStatus(401);
    }

    private static String getMd5(String input)
    {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] messageDigest = md.digest(input.getBytes());

            BigInteger no = new BigInteger(1, messageDigest);

            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}