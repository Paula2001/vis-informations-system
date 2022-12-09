package com.example.vis.middlewares;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.io.PrintWriter;

public class AdminNotLogin implements Filter{

    public void init(FilterConfig arg0) throws ServletException {}

    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {
        Object isLoggedInAdmin =  ((HttpServletRequest) req).getSession().getAttribute("isLoggedInAdmin");
        String valueOfSession = isLoggedInAdmin != null? isLoggedInAdmin.toString() : "false" ;

        if (valueOfSession.equals("false")){
            chain.doFilter(req, resp);
            return;
        }
        // redirect to the admin
    }
    public void destroy() {
        // TODO this is should be with the destruction of the object
    }
}