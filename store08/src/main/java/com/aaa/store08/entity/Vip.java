package com.aaa.store08.entity;

import java.io.Serializable;
import java.util.Date;

public class Vip implements Serializable {
    private Integer vid;
    private String vName;
    private String vCount;
    private Date vBegindate;
    private String vPhone;
    private Double vAcount;
    private Integer vState;
    private double vSum;

    public double getvSum() {
        return vSum;
    }

    public void setvSum(double vSum) {
        this.vSum = vSum;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    public String getvCount() {
        return vCount;
    }

    public void setvCount(String vCount) {
        this.vCount = vCount;
    }

    public Date getvBegindate() {
        return vBegindate;
    }

    public void setvBegindate(Date vBegindate) {
        this.vBegindate = vBegindate;
    }

    public String getvPhone() {
        return vPhone;
    }

    public void setvPhone(String vPhone) {
        this.vPhone = vPhone;
    }

    public Double getvAcount() {
        return vAcount;
    }

    public void setvAcount(Double vAcount) {
        this.vAcount = vAcount;
    }

    public Integer getvState() {
        return vState;
    }

    public void setvState(Integer vState) {
        this.vState = vState;
    }
}
