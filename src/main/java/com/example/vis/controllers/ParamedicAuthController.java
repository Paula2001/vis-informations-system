package com.example.vis.controllers;

import com.example.vis.helpers.Helper;
import com.example.vis.models.ParamedicModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class ParamedicAuthController extends Controller {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("paramedic-login.jsp").forward(request, response);
    }


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ParamedicModel paramedic = new ParamedicModel();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        List<ParamedicModel> paramedics = paramedic.where("where email = " + "'" + email + "'");

        if (Helper.getMd5(password).equals(paramedics.get(0).getPassword())) {
            req.getSession().setAttribute("isLoggedParamedic", "true");
            req.getSession().setAttribute("email", email);
            req.getSession().setAttribute("id", paramedics.get(0).getId());
            req.getSession().setAttribute("name", paramedics.get(0).getName());
            req.getSession().setAttribute("dateOfBirth", paramedics.get(0).getDataOfBirth());
            req.getSession().setAttribute("is_authorized", paramedics.get(0).getIsAuthorized());
            resp.getWriter().println(Helper.getServerRoute(req) + "/paramedic");
            resp.setStatus(200);
            return;
        }
        resp.setStatus(401);
    }

    @Override
    public void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("isLoggedParamedic", "false");
        req.getSession().setAttribute("email", null);
        req.getSession().setAttribute("id", null);
        req.getSession().setAttribute("name", null);
        req.getSession().setAttribute("dateOfBirth", null);
        req.getSession().setAttribute("is_authorized", null);
        resp.sendRedirect(Helper.getServerRoute(req) + "/paramedic-login");
    }
}