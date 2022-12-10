package com.example.vis.helpers;

import jakarta.servlet.http.HttpServletRequest;

import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.math.BigInteger;
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

    public static String getMd5(String input)
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
