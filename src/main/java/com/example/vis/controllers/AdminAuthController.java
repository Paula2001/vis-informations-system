package com.example.vis.controllers;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import com.example.vis.models.AdminModel;
import jakarta.servlet.ServletException;
import com.example.vis.helpers.Helper;
import java.io.IOException;
import java.util.List;

public class AdminAuthController extends Controller {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("admin-login.jsp").forward(request, response);
    }


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        AdminModel admin = new AdminModel();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        List<AdminModel> admins = admin.where("where email = " + "'" + email + "'");
        if (Helper.getMd5(password).equals(admins.get(0).getPassword())) { // TODO : lovely SQL injection <3
            req.getSession().setAttribute("isLoggedInAdmin", "true");
            req.getSession().setAttribute("email", email);
            req.getSession().setAttribute("id", admins.get(0).getId());
            req.getSession().setAttribute("name", admins.get(0).getName());
            resp.getWriter().println(Helper.getServerRoute(req) + "/admin");
            resp.setStatus(200);
            return;
        }
        resp.setStatus(401);
    }

    @Override
    public void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("isLoggedInAdmin", "false");
        req.getSession().setAttribute("adminEmail", null);
        req.getSession().setAttribute("adminId", null);
        req.getSession().setAttribute("adminName", null);
        resp.sendRedirect(Helper.getServerRoute(req) + "/admin-login");
    }
}