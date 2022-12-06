package com.example.vis.models;

import java.util.ArrayList;
import java.util.List;

public class Model<T> {
    List<T> models = new ArrayList<T>();
    public void addToModels(T mo) {
        models.add(mo);
    }

    public List<T> getModels() {
        return models;
    }
}
