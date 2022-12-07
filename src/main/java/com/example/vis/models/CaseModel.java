package com.example.vis.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CaseModel extends Model<CaseModel> {
    private final int id ;
    private final String dataOfBirth;
    private final String name;
    private final String email;
    private final String password;

    public CaseModel(int id, String dataOfBirth, String name, String email, String password) {
        this.id = id;
        this.dataOfBirth = dataOfBirth;
        this.name = name;
        this.email = email;
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

    @Override
    protected String getTableName() {
        return "cases";
    }

    @Override
    protected CaseModel getModelInstance(ResultSet result) throws SQLException {
        return null;
    }
}
