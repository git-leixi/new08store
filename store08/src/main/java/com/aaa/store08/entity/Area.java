package com.aaa.store08.entity;

import java.io.Serializable;

public class Area implements Serializable {
    private Integer aId;
    private String aName;
    private String aMain;
    private Integer uId;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaMain() {
        return aMain;
    }

    public void setaMain(String aMain) {
        this.aMain = aMain;
    }
}
