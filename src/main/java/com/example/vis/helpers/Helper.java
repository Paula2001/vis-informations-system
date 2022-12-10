package com.example.vis.helpers;

import java.util.HashMap;

public class Helper {
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
}
