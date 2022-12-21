package com.example.vis.database;

import com.example.vis.models.IModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class SQLConnection implements IDatabaseConnection<Connection> {

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
            this.closeConnection();
            System.out.println(e.getMessage());
        }
        this.closeConnection();
        return result;
    }

    public void insertMany(String tableName, ArrayList<HashMap<String, HashMap<String, String>>> values) throws SQLException, NamingException {
        ArrayList<Integer> ids = new ArrayList<Integer>();
        for (HashMap<String, HashMap<String, String>> val:values) {
            ids.add(this.insert(tableName,val));
        }
        // return the array of ids;
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
        PreparedStatement preparedStatement = instance.getConnection().prepareStatement(string, Statement.RETURN_GENERATED_KEYS);
        values.forEach((k, v) -> {
            if(v.get("value") != null) {
                ++wrapper.len;
                switch (v.get("type")) {
                    case "string":
                        try {
                            preparedStatement.setString(wrapper.len,v.get("value"));
                        } catch (SQLException e) {
                            this.closeConnection();
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "int":
                        try {
                            preparedStatement.setInt(wrapper.len ,Integer.parseInt(v.get("value")));
                        } catch (SQLException e) {
                            this.closeConnection();
                            System.out.println(e.getMessage());

                        }
                }
            }

        });
        preparedStatement.execute();
        ResultSet result = preparedStatement.getGeneratedKeys();
        result.next();
        int id = result.getInt(1);
        this.closeConnection();
        return id;
    }

    public void closeConnection() {
        try {
            this.getConnection().close();
        } catch (SQLException | NamingException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public ArrayList<IModel[]> getWithJoin(IModel firstModel, IModel secondModel , IModel thirdModel) throws SQLException, NamingException {
        ArrayList<IModel[]> modelsArray = new ArrayList();
        ResultSet result = this.getConnection().createStatement().executeQuery("select * from video join tutorial tutorial on tutorial.id = video.tutorial_id left join paramedics_videos pv on video.id = pv.video_id");
        while (result.next()) {// TODO this should be removed and apply query builder
            IModel[] modelArray = {
                    (IModel) firstModel.getModelInstance(result),
                    (IModel) secondModel.getModelInstance(result),
                    (IModel)  thirdModel.getModelInstance(result)
            };
            modelsArray.add(modelArray);
        }
        return modelsArray;
    }

    public void update(String videoId) throws SQLException, NamingException {
        System.out.println("________________________________");
        System.out.println(videoId);
        this.getConnection().createStatement().execute("UPDATE paramedics_videos set is_watched = 1 WHERE video_id = "+ videoId +" AND paramedic_id = 1"); // TODO we need to make this related to the model
    }

    public void updateMany() {

    }

}
