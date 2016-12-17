package com.xubh01.po;

import java.sql.Time;

public class T_user2 {
    private Integer id;
    private String pwd;
    private String username;
    private Time regTime;


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

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

    public void setRegTime(Time regTime) {
        this.regTime = regTime;
    }

    public Time getRegTime() {
        return regTime;
    }
}
