package com.aaa.store08.entity;

import java.io.Serializable;

public class UJob implements Serializable {
    //用户信息表
    private Integer uId;
    private String uUsername;
    private Integer uJob;
    private String jName;
    private Integer jPermission;
    private Integer aId;

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

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

    public Integer getuJob() {
        return uJob;
    }

    public void setuJob(Integer uJob) {
        this.uJob = uJob;
    }

    public String getjName() {
        return jName;
    }

    public void setjName(String jName) {
        this.jName = jName;
    }

    public Integer getjPermission() {
        return jPermission;
    }

    public void setjPermission(Integer jPermission) {
        this.jPermission = jPermission;
    }

    @Override
    public String toString() {
        return "UJob{" +
                "uId=" + uId +
                ", uUsername='" + uUsername + '\'' +
                ", uJob=" + uJob +
                ", jName='" + jName + '\'' +
                ", jPermission=" + jPermission +
                '}';
    }
}
