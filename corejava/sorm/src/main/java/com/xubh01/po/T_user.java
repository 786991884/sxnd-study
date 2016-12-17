package com.xubh01.po;

import java.sql.*;

public class T_user {
    private String pwd;
    private String username;
    private Blob headImg;
    private java.sql.Date regTime;
    private Integer iddddd;
    private Time lastLoginTime;
    private Clob myInfo;


    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPwd() {
        return pwd;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setHeadImg(Blob headImg) {
        this.headImg = headImg;
    }

    public Blob getHeadImg() {
        return headImg;
    }

    public void setRegTime(java.sql.Date regTime) {
        this.regTime = regTime;
    }

    public java.sql.Date getRegTime() {
        return regTime;
    }

    public void setIddddd(Integer iddddd) {
        this.iddddd = iddddd;
    }

    public Integer getIddddd() {
        return iddddd;
    }

    public void setLastLoginTime(Time lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Time getLastLoginTime() {
        return lastLoginTime;
    }

    public void setMyInfo(Clob myInfo) {
        this.myInfo = myInfo;
    }

    public Clob getMyInfo() {
        return myInfo;
    }
}
