package com.example.vis.models;

import java.sql.ResultSet;
import java.sql.SQLException;

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
    protected String getTableName() {
        return "certification";
    }

    @Override
    protected CertificationModel getModelInstance(ResultSet result) throws SQLException {
        return null;
    }
}
