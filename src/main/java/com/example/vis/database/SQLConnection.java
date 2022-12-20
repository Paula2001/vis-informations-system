package com.example.vis.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class SQLConnection implements DatabaseConnection<Connection>{

    @Override
    public Connection getConnection() throws SQLException, NamingException {
        Context initContext = new InitialContext();
        Context envContext = (Context) initContext.lookup("java:comp/env");
        DataSource ds = (DataSource) envContext.lookup("jdbc/UsersDB");
        return ds.getConnection();
    }

    public ResultSet select(String resource,String cols, String where) {
        String sqlQ = (new StringBuilder())
                .append("SELECT")
                .append(" ")
                .append(cols)
                .append(" FROM ")
                .append(resource)
                .append(" ")
                .append(where)
                .append(" ")
                .toString();
        ResultSet result = null;
        try {
            Statement statement = this.getConnection().createStatement();
            result = statement.executeQuery(sqlQ);
        } catch (SQLException|NamingException e) {
            // TODO : should log the error message
            System.out.println(e.getMessage());
        }
        return result;
    }

    public void insertMany() {

    }

    public int insert(String tableName,HashMap<String, HashMap<String, String>> values) throws SQLException, NamingException {
        var wrapper = new Object(){
            int len = 0;
            String cols = "";
            String questionMarks = "";
        };
        values.forEach((k, v) -> {
            ++wrapper.len;
            String trailingComma = wrapper.len < values.size() ? ",": "";
            wrapper.cols += k + trailingComma;
            wrapper.questionMarks += "?" + trailingComma;

        });
        var instance = this;
        wrapper.len = 0;
        String string = "INSERT INTO " + tableName + "( " + wrapper.cols+ " )" + " VALUES " + "(" + wrapper.questionMarks +  ")";
        PreparedStatement preparedStatement = instance.getConnection().prepareStatement(string);
        values.forEach((k, v) -> {
            if(v.get("value") != null) {
                ++wrapper.len;
                switch (v.get("type")) {
                    case "string":
                        try {
                            preparedStatement.setString(wrapper.len,v.get("value"));
                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "int":
                        try {
                            preparedStatement.setInt(wrapper.len ,Integer.parseInt(v.get("value")));
                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                        }
                }
            }

        });
        return preparedStatement.executeUpdate();
    }


    public void update(){

    }

    public void updateMany() {

    }

}
