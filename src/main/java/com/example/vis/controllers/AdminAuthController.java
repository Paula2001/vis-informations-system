package com.example.vis.controllers;


import com.example.vis.models.AdminModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class AdminAuthController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("admin-login.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        AdminModel admin = new AdminModel();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        List<AdminModel> admins = admin.where("where email = " + "'" + email + "'");
        if (getMd5(password).equals(admins.get(0).getPassword())) { // TODO : lovely SQL injection <3
            req.getSession().setAttribute("isLoggedInAdmin", "true");
            req.getSession().setAttribute("adminEmail", email);
            req.getSession().setAttribute("adminId", admins.get(0).getId());
            req.getSession().setAttribute("adminName", admins.get(0).getName());
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