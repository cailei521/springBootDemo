package com.itheima.spring_bootcrud.pojo;

/**
 * Created by 1111111 on 2018/8/27.
 */
public class User {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
