package com.example.vis.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public interface IModel<T> {
    String getTableName();
    T getModelInstance(ResultSet result) throws SQLException;
    HashMap<String, HashMap<String, String>> getData();
    ArrayList<String> getCols();
}
