package com.zsp.bean;

import java.io.Serializable;

/**
 * description:
 * author：Andy on 2020/11/16 0016-16:14
 * email:zsp872126510@gmail.com
 */
public class User implements Serializable {
    private int id;
    private String name;
    private String password;
    private String email;
    private String image_path;
    private boolean role;

    public User() {
    }

    public User(String name, String password, String email, String image_path, boolean role) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.image_path = image_path;
        this.role = role;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", image_path='" + image_path + '\'' +
                ", role=" + role +
                '}';
    }
}
