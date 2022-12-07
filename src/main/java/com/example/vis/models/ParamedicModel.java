package com.example.vis.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ParamedicModel extends Model<ParamedicModel> {
    private final int id ;
    private final String dataOfBirth;
    private final String name;
    private final String email;

    private final String isAuthorized;
    private final String password;

    public ParamedicModel(int id, String dataOfBirth, String name, String email, String isAuthorized, String password) {
        this.id = id;
        this.dataOfBirth = dataOfBirth;
        this.name = name;
        this.email = email;
        this.isAuthorized = isAuthorized;
        this.password = password;
    }

    public int getId() {
        return id;
    }
    public String getDataOfBirth() {
        return dataOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getIsAuthorized() {
        return isAuthorized;
    }

    @Override
    protected String getTableName() {
        return "paramedic";
    }

    @Override
    protected ParamedicModel getModelInstance(ResultSet result) throws SQLException {
        return null;
    }
}
