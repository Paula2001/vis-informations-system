package com.example.vis.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class VideoModel extends Model<VideoModel> {
    private int id ;
    private String url;
    private int tutorialId;
    private TutorialModel tutorialModel;

    public VideoModel(String url, int tutorialId ){
        this.url = url;
        this.tutorialId = tutorialId;
    }

    public VideoModel(){

    }

    public TutorialModel getTutorialModel() {
        return tutorialModel;
    }

    public void setTutorialModel(TutorialModel tutorialModel) {
        this.tutorialModel = tutorialModel;
    }

    public int getId() {
        return id;
    }

    public int getTutorialId() {
        return tutorialId;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String getTableName() {
        return "video";
    }

    @Override
    public VideoModel getModelInstance(ResultSet result) throws SQLException {
        this.id = result.getInt("id");
        this.tutorialId = result.getInt("tutorial_id");
        this.url = result.getString("url");
        return this;
    }
    @Override
    public HashMap<String, HashMap<String, String>> getData() {
        var data = new HashMap<String, HashMap<String, String>>();

        if (this.id != 0){
            var id = new HashMap<String, String>();
            id.put("type","int");
            id.put("value", Integer.toString(this.id));
            data.put("id" , id);
        }

        var url = new HashMap<String, String>();
        url.put("type","string");
        url.put("value", this.url);

        var tutorialId = new HashMap<String, String>();
        tutorialId.put("type","int");
        tutorialId.put("value", Integer.toString(this.tutorialId));

        data.put("url" , url);
        data.put("tutorial_id" , tutorialId);
        return data;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTutorialId(int tutorialId) {
        this.tutorialId = tutorialId;
    }

    @Override
    public ArrayList<String> getCols() {
        ArrayList<String> cols =  new ArrayList<String>();
        cols.add("id");
        cols.add("name");
        cols.add("tutorial_id");
        return cols;
    }
}
