package com.example.vis.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class AdminModel extends Model<AdminModel>  {
    private int id ;
    private String name;
    private String email;
    private String password;


    public int getId() {
        return id;
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
        return "admin";
    }

    @Override
    public AdminModel getModelInstance(ResultSet result) {
        try {
            this.id = Integer.parseInt(result.getString("id"));
            this.name = result.getString("name");
            this.email = result.getString("email");
            this.password = result.getString("password");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return this;
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
