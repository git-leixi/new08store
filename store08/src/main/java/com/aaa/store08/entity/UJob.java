package com.aaa.store08.entity;

import java.io.Serializable;

public class UJob implements Serializable {
    //用户信息表
    private Integer uId;
    private String uUsername;
    private Integer uJob;
    private String jName;

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


}
