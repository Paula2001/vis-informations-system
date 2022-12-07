package com.example.vis.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TutorialModel extends Model<TutorialModel> {
    private final int id ;
    private final String name;
    private final String description;

    public TutorialModel(int id, String name, String description, String password) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    protected String getTableName() {
        return "tutorial";
    }

    @Override
    protected TutorialModel getModelInstance(ResultSet result) throws SQLException {
        return null;
    }
}
