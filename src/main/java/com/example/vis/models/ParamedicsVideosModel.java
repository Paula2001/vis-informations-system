package com.example.vis.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class ParamedicsVideosModel extends Model<ParamedicsVideosModel> {
    private int id ;
    private int paramedic_id;
    private int video_id;

    private int is_watched;
    public ParamedicsVideosModel(int paramedicId, int videoId ){
        this.paramedic_id = paramedicId;
        this.video_id = videoId;
        this.is_watched = 0;
    }

    public int getIs_watched() {
        return is_watched;
    }

    public ParamedicsVideosModel(){

    }

    public void setParamedic_id(int paramedic_id) {
        this.paramedic_id = paramedic_id;
    }

    public void setVideo_id(int video_id) {
        this.video_id = video_id;
    }

    @Override
    public String getTableName() {
        return "paramedics_videos";
    }

    @Override
    public ParamedicsVideosModel getModelInstance(ResultSet result) throws SQLException {
        var x = new ParamedicsVideosModel();
        x.id = result.getInt("id");
        x.is_watched = result.getInt("is_watched");
        return x;
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
        var paramedicId = new HashMap<String, String>();
        paramedicId.put("type","int");
        paramedicId.put("value", Integer.toString(this.paramedic_id));
        data.put("paramedic_id" , paramedicId);

        var videoId = new HashMap<String, String>();
        videoId.put("type","int");
        videoId.put("value", Integer.toString(this.video_id));
        data.put("video_id" , videoId);
        return data;
    }



    @Override
    public ArrayList<String> getCols() {
        ArrayList<String> cols =  new ArrayList<String>();
        cols.add("id");
        cols.add("paramedic_id");
        cols.add("video_id");
        return cols;
    }
}
