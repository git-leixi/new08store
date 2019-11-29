package com.aaa.commodity.entity;

import java.io.Serializable;

public class CatagoryVO implements Serializable {
    private Integer catagoryid;
    private String catagoryname;

    public Integer getCatagoryid() {
        return catagoryid;
    }

    public void setCatagoryid(Integer catagoryid) {
        this.catagoryid = catagoryid;
    }

    public String getCatagoryname() {
        return catagoryname;
    }

    public void setCatagoryname(String catagoryname) {
        this.catagoryname = catagoryname;
    }
}
