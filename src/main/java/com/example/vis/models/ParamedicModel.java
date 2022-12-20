package com.example.vis.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class ParamedicModel extends Model<ParamedicModel> {
    private int id ;
    private String dataOfBirth;
    private String name;
    private String email;
    private boolean isAuthorized;
    private String password;


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

    public boolean getIsAuthorized() {
        return isAuthorized;
    }

    @Override
    protected String getTableName() {
        return "paramedic";
    }

    @Override
    protected ParamedicModel getModelInstance(ResultSet result) {
        try {
            this.id = Integer.parseInt(result.getString("id"));
            this.name = result.getString("name");
            this.email = result.getString("email");
            this.password = result.getString("password");
            this.dataOfBirth = result.getString("date_of_birth");
            this.isAuthorized = Boolean.parseBoolean(result.getString("is_authorized"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return this;
    }


    @Override
    protected HashMap<String, HashMap<String, String>> getData() {
        return new HashMap<>();
    }

    @Override
    protected ArrayList<String> getCols() {
        return null;
    }
}
