package com.example.vis.models;

import com.example.vis.database.DatabaseConnection;
import com.example.vis.database.SQLConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

abstract class Model<T> {
    List<T> models = new ArrayList<T>();
    protected abstract String getTableName();
    protected abstract T getModelInstance(ResultSet result) throws SQLException;
    protected static final DatabaseConnection<Connection> DATABASE_CONNECTION = new SQLConnection();

    public List<T> getAll() {
        ResultSet result = DATABASE_CONNECTION.select(this.getTableName(),"*","");

        try{
            while (result.next()) {
                models.add(getModelInstance(result));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return models;
    }

    public List<T> where(String whereString) {
        ResultSet result = DATABASE_CONNECTION.select(this.getTableName(), "*", whereString);

        try{
            while (result.next()) {
                models.add(getModelInstance(result));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return models;

    }
}
