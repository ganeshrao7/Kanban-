package com.niit.model;

public class User {

    private int userId;
    private String userName;
    private String password;
    private String phoneNo;
    private String email;

    public User()
    {

    }

    public User(int userId, String userName, String password, String phoneNo, String email) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


