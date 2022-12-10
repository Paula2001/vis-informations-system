package com.example.vis.helpers;

import jakarta.servlet.http.HttpServletRequest;

import java.util.HashMap;

public class Helper {
    private static final boolean isDev  = true;
    public static HashMap<String, String> createRoute(
            String url,
            String name,
            String realRoute,
            String isLoggedIn
    ) {
        HashMap<String,String> homeRoute = new HashMap<>();
        homeRoute.put("url", url);
        homeRoute.put("name", name);
        homeRoute.put("realRoute", realRoute);
        homeRoute.put("isLoggedIn", isLoggedIn);
        return homeRoute;
    }

    public static String getServerRoute(HttpServletRequest req) {
        if (isDev) {
            return "http://"+req.getServerName() + ":" + req.getServerPort();
        }
        return "https://"+req.getServerName();
    }
}
