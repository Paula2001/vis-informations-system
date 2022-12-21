package com.example.vis.models;

import com.example.vis.database.IDatabaseConnection;
import com.example.vis.database.SQLConnection;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
abstract class Model<T> implements IModel<T> {
    List<T> models = new ArrayList<T>();

    protected static final IDatabaseConnection<Connection> DATABASE_CONNECTION = new SQLConnection();

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

    public int insert() {
        System.out.println(this.getData());
        try {
            return DATABASE_CONNECTION.insert(this.getTableName(), this.getData());
        }catch (SQLException | NamingException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }
}
