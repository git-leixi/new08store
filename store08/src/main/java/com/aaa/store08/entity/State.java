package com.aaa.store08.entity;

import java.io.Serializable;

public class State implements Serializable {
    private Integer sId;
    private String sName;

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }
}
