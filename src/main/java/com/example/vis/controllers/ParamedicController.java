package com.example.vis.controllers;

import com.example.vis.helpers.Helper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class ParamedicController extends Controller {
    private static final String UPLOAD_DIRECTORY = "videos";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("uploaded",request.getParameter("uploaded"));
        request.getRequestDispatcher("paramedic.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uploadPath = getServletContext().getRealPath("") + UPLOAD_DIRECTORY;

        File uploadDir = new File(uploadPath);

        String succeded = "";

        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        };

        for (Part part : req.getParts()) {
            String fileName = Helper.getFileName(part);
            if (!fileName.equals("")) succeded = "?uploaded=true";

            try {
                part.write(uploadPath + File.separator + fileName);
            }catch (IOException e){

            }
        }

        resp.sendRedirect(Helper.getServerRoute(req) + "/paramedic" + succeded);
    }


}