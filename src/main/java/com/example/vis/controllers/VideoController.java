package com.example.vis.controllers;

import com.example.vis.database.SQLConnection;
import com.example.vis.helpers.Helper;
import com.example.vis.models.ParamedicModel;
import com.example.vis.models.ParamedicsVideosModel;
import com.example.vis.models.TutorialModel;
import com.example.vis.models.VideoModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import javax.naming.NamingException;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class VideoController extends Controller {
    private static final String UPLOAD_DIRECTORY = "videos";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String videoId = request.getParameter("id");
        var models = new VideoModel(); // TODO I don't like this
        var videos = models.where("where id = " + videoId);
        var id = request.getSession().getAttribute("id").toString();
        var videoParamedic = new ParamedicsVideosModel(
                Integer.parseInt(id),
                Integer.parseInt(videoId)
        );
        var paramedicVideos = videoParamedic.where("where video_id = "+videoId+ " AND paramedic_id = " + 1);
        System.out.println("todo");
        System.out.println(paramedicVideos);
        System.out.println("todo");
        if (paramedicVideos.size() == 0) {
            videoParamedic.insert();
        }
        System.out.println(videos.get(0).getUrl());
        request.setAttribute("videoURL", videos.get(0).getUrl());
        request.setAttribute("tutorialName", request.getParameter("tutorialName"));
        request.setAttribute("video_id", videoId);

        request.getRequestDispatcher("video.jsp").forward(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        try {
            (new SQLConnection()).update(req.getParameter("video_id"));
        } catch (SQLException | NamingException e) {
            System.out.println(e.getMessage());
        }
    }
}