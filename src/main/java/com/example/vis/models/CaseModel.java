package com.example.vis.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

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
    public String getTableName() {
        return "cases";
    }

    @Override
    public CaseModel getModelInstance(ResultSet result) throws SQLException {
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
