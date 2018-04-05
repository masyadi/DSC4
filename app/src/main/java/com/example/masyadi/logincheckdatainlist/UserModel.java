package com.example.masyadi.logincheckdatainlist;

/**
 * Created by Lab1-01 on 4/5/2018.
 */

public class UserModel {

    private String email;
    private String password;

    public UserModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
