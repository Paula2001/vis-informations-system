package com.example.vis.middlewares;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ParamedicLogin implements Filter{

    public void init(FilterConfig arg0) throws ServletException {}

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        Object isLoggedInAdmin =  ((HttpServletRequest) req).getSession().getAttribute("isLoggedInParamedic");
        String valueOfSession = isLoggedInAdmin != null? isLoggedInAdmin.toString() : "false" ;

        if (valueOfSession.equals("true")){
            chain.doFilter(req, resp);
            return;
        }
        ((HttpServletResponse) resp).sendRedirect("http://localhost:8080/paramedic-login");
    }
    public void destroy() {
        // TODO this is should be with the destruction of the object
    }
}