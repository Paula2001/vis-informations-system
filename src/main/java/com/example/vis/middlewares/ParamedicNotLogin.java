package com.example.vis.middlewares;

import com.example.vis.controllers.AdminAuthController;
import com.example.vis.controllers.ParamedicAuthController;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ParamedicNotLogin implements Filter{

    public void init(FilterConfig arg0) throws ServletException {}

    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {
        Object isLoggedInParamedic =  ((HttpServletRequest) req).getSession().getAttribute("isLoggedInParamedic");
        String valueOfSession = isLoggedInParamedic != null? isLoggedInParamedic.toString() : "false" ;

        if (((HttpServletRequest) req).getParameter("_method") != null && req.getParameter("_method").equals("put")) {
            (new ParamedicAuthController()).doPut((HttpServletRequest) req,(HttpServletResponse) resp);
            return;
        }


        if (valueOfSession.equals("false")){
            chain.doFilter(req, resp);
            return;
        }
        ((HttpServletResponse) resp).sendRedirect("http://localhost:8080/paramedic");
        // redirect to the admin
    }
    public void destroy() {
        // TODO this is should be with the destruction of the object
    }
}