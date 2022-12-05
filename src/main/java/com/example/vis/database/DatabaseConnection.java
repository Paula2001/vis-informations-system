package com.example.vis.database;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

public interface DatabaseConnection<T> {
    T getConnection() throws SQLException, NamingException;
}
