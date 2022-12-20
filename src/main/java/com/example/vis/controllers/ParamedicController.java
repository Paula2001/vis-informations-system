package com.example.vis.controllers;

import com.example.vis.database.SQLConnection;
import com.example.vis.helpers.Helper;
import com.example.vis.models.TutorialModel;
import com.example.vis.models.VideoModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import javax.naming.NamingException;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class ParamedicController extends Controller {
    private static final String UPLOAD_DIRECTORY = "videos";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            var models = (new SQLConnection()).getWithJoin(new TutorialModel(), new VideoModel()); // TODO I don't like this
            request.setAttribute("videos", models);
        } catch (SQLException | NamingException e) {
            System.out.println(e.getMessage());
        }
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