package com.example.vis.middlewares;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter implements Filter{

    public void init(FilterConfig arg0) throws ServletException {}

    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {
        PrintWriter out=resp.getWriter();
        out.print("filter is invoked before");

        chain.doFilter(req, resp);

        out.print("filter is invoked after");
    }
    public void destroy() {
        // TODO this is should be with the destruction of the object
    }
}