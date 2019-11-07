package com.aaa.store08.entity;

import java.io.Serializable;

public class Kind implements Serializable {
    private Integer kId;
    private String kName;

    public Integer getkId() {
        return kId;
    }

    public void setkId(Integer kId) {
        this.kId = kId;
    }

    public String getkName() {
        return kName;
    }

    public void setkName(String kName) {
        this.kName = kName;
    }
}
