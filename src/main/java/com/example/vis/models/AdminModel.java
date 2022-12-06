package com.example.vis.models;

public class AdminModel extends Model<CaseModel> {
    private final int id ;
    private final String name;
    private final String email;
    private final String password;

    public AdminModel(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
