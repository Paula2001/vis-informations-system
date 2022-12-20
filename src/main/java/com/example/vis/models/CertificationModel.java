package com.example.vis.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class CertificationModel extends Model<CertificationModel> {
    private final int id ;
    private final String issuedAt;
    private final ParamedicModel paramedic;
    private final String tutorial;

    public CertificationModel(int id, String issuedAt, ParamedicModel paramedic, String tutorial) {
        this.id = id;
        this.issuedAt = issuedAt;
        this.paramedic = paramedic;
        this.tutorial = tutorial;
    }

    public int getId() {
        return id;
    }

    public String getIssuedAt() {
        return issuedAt;
    }

    public ParamedicModel getParamedic() {
        return paramedic;
    }

    public String getTutorial() {
        return tutorial;
    }

    @Override
    public String getTableName() {
        return "certification";
    }

    @Override
    public CertificationModel getModelInstance(ResultSet result) throws SQLException {
        return null;
    }


    @Override
    public HashMap<String, HashMap<String, String>> getData() {
        return new HashMap<>();
    }

    @Override
    public ArrayList<String> getCols() {
        return null;
    }
}
