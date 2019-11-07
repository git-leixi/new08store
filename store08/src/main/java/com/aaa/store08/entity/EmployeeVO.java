package com.aaa.store08.entity;

import java.io.Serializable;
import java.util.Date;

public class EmployeeVO implements Serializable {
    private  Integer eId;
    private String   eName;
    private String eSex;
    private String eAge;
    private Date eBirthday;
    private Integer eState;
    private Integer eArea;
    private Integer eJob;
    private Integer jId;
    private String jName;
    private Integer jPersmission;
    private Integer sId;
    private String sName;
    private Integer aId;
    private String aName;
    private String aMain;
    private  String eNewDate;

    public String geteNewDate() {
        return eNewDate;
    }

    public void seteNewDate(String eNewDate) {
        this.eNewDate = eNewDate;
    }

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
