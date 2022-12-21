package com.example.vis.controllers;

import com.example.vis.helpers.Helper;
import com.example.vis.models.AdminModel;
import com.example.vis.models.TutorialModel;
import com.example.vis.models.VideoModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 100,
        maxFileSize = 1024 * 1024 * 100,
        maxRequestSize = 1024 * 1024 * 100)
public class AdminController extends Controller {
    private static final String UPLOAD_DIRECTORY = "videos";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("uploaded",request.getParameter("uploaded"));
        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TutorialModel tutorialModel = new TutorialModel();
        String tutorialName = req.getParameter("tutorial_name");
        String tutorialDescription = req.getParameter("tutorial_description");
        tutorialModel.setName(tutorialName);
        tutorialModel.setDescription(tutorialDescription);
        int tutorialID = tutorialModel.insert();
        String uploadPath = getServletContext().getRealPath("") + UPLOAD_DIRECTORY;

        File uploadDir = new File(uploadPath);

        String succeded = "";

        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        };

        for (Part part : req.getParts()) {
            String fileName = Helper.getFileName(part);
            if (!fileName.equals("")){
                VideoModel videoModel = new VideoModel(fileName,tutorialID);
                videoModel.insert();
                succeded = "?uploaded=true";

                try {
                    part.write(uploadPath + File.separator + fileName);
                }catch (IOException e){
                    System.out.println(e.getMessage());
                }
            }

        }

        resp.sendRedirect(Helper.getServerRoute(req) + "/admin" + succeded);
    }


}