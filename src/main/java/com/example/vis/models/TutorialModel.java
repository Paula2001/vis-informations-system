package com.example.vis.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class TutorialModel extends Model<TutorialModel> {
    private int id ;
    private String name;
    private String description;
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
    public String getTableName() {
        return "tutorial";
    }

    @Override
    public TutorialModel getModelInstance(ResultSet result) throws SQLException {
        var x = new TutorialModel();
        x.id = Integer.parseInt(result.getString("id"));
        x.name = result.getString("name");
        x.description = result.getString("description");
        return x;
    }
    @Override
    public HashMap<String, HashMap<String, String>> getData() {
        var data = new HashMap<String, HashMap<String, String>>();

        if (this.id != 0){
            var id = new HashMap<String, String>();
            id.put("type","int");
            id.put("value", Integer.toString(this.id));
            data.put("id" , id);
        }

        var name = new HashMap<String, String>();
        name.put("type","string");
        name.put("value", this.name);
        var description = new HashMap<String, String>();
        description.put("type","string");
        description.put("value", this.description);

        data.put("name" , name);
        data.put("description" , description);
        return data;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public ArrayList<String> getCols() {
        ArrayList<String> cols =  new ArrayList<String>();
        cols.add("id");
        cols.add("name");
        cols.add("description");
        return cols;
    }
}
