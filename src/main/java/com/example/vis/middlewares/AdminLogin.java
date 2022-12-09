package com.example.vis.middlewares;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class AdminLogin implements Filter{

    public void init(FilterConfig arg0) throws ServletException {}

    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {
//        PrintWriter out=resp.getWriter();
//        if (!((HttpServletRequest) req).getSession().getAttribute("isLoggedInAdmin").equals("true")) {
            chain.doFilter(req, resp);
//        }

//        out.print("filter is invoked after");
    }
    public void destroy() {
        // TODO this is should be with the destruction of the object
    }
}