package com.aaa.store08.entity;

import java.io.Serializable;

public class Job implements Serializable {
    private Integer jId;
    private  String jName;
    private Integer jPersmission;

    public Integer getjId() {
        return jId;
    }

    public void setjId(Integer jId) {
        this.jId = jId;
    }

    public String getjName() {
        return jName;
    }

    public void setjName(String jName) {
        this.jName = jName;
    }

    public Integer getjPersmission() {
        return jPersmission;
    }

    public void setjPersmission(Integer jPersmission) {
        this.jPersmission = jPersmission;
    }
}
