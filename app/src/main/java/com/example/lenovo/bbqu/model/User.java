package com.example.lenovo.bbqu.model;

/**
 * Created by lenovo on 2016/6/12.
 */
public class User {
    String userName;
    long userID;
    long passWord;
    public User(){}

    public User(String userName, long userID, long passWord){
        this.userName=userName;
        this.userID=userID;
        this.passWord=passWord;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public void setPassWord(long passWord) {
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public long getUserID() {
        return userID;
    }

    public long getPassWord() {
        return passWord;
    }
}
