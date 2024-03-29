package com.example.vis.database;

import com.example.vis.models.IModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.naming.NamingException;

public interface IDatabaseConnection<T> {
    T getConnection() throws SQLException, NamingException;

    ResultSet select(String resource, String cols, String where);

    int insert(String tableName, HashMap<String, HashMap<String, String>> values) throws SQLException, NamingException;

    void closeConnection();

    ArrayList<IModel[]> getWithJoin(IModel x, IModel y,IModel z) throws SQLException, NamingException;
}