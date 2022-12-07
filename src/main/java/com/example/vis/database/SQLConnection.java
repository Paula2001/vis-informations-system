package com.example.vis.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


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

    public void insert() {

    }

    public void update(){

    }

    public void updateMany() {

    }

}
