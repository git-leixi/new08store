package com.aaa.store08.entity;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {
    private  Integer eId;
    private String   eName;
    private String eSex;
    private String eAge;
    private Date eBirthday;
    private Integer eState;
    private Integer eArea;
    private Integer eJob;

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String geteSex() {
        return eSex;
    }

    public void seteSex(String eSex) {
        this.eSex = eSex;
    }

    public String geteAge() {
        return eAge;
    }

    public void seteAge(String eAge) {
        this.eAge = eAge;
    }

    public Date geteBirthday() {
        return eBirthday;
    }

    public void seteBirthday(Date eBirthday) {
        this.eBirthday = eBirthday;
    }

    public Integer geteState() {
        return eState;
    }

    public void seteState(Integer eState) {
        this.eState = eState;
    }

    public Integer geteArea() {
        return eArea;
    }

    public void seteArea(Integer eArea) {
        this.eArea = eArea;
    }

    public Integer geteJob() {
        return eJob;
    }

    public void seteJob(Integer eJob) {
        this.eJob = eJob;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eId=" + eId +
                ", eName='" + eName + '\'' +
                ", eSex='" + eSex + '\'' +
                ", eAge='" + eAge + '\'' +
                ", eBirthday=" + eBirthday +
                ", eState=" + eState +
                ", eArea=" + eArea +
                ", eJob=" + eJob +
                '}';
    }
}
