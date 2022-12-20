package com.example.vis.database;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.naming.NamingException;

public interface DatabaseConnection<T> {
    T getConnection() throws SQLException, NamingException;

    ResultSet select(String resource, String cols, String where);

    public int insert(String tableName, HashMap<String, HashMap<String, String>> values) throws SQLException, NamingException;
}