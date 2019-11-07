package com.aaa.store08.entity;

import java.io.Serializable;

public class Users implements Serializable {
    //用户信息表
    private Integer uId;
    private String uUsername;
    private String uPassword;
    private Integer uJob;
    private Integer uPermission;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuUsername() {
        return uUsername;
    }

    public void setuUsername(String uUsername) {
        this.uUsername = uUsername;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public Integer getuJob() {
        return uJob;
    }

    public void setuJob(Integer uJob) {
        this.uJob = uJob;
    }

    public Integer getuPermission() {
        return uPermission;
    }

    public void setuPermission(Integer uPermission) {
        this.uPermission = uPermission;
    }
}
