package com.aaa.store08.entity;

import java.io.Serializable;
import java.util.Date;

public class VipVO implements Serializable {
    private int vPassword;
    private int vPpassword;
    private Integer vid;
    private String vName;
    private String vCount;
    private double oPrice;
    private Date oDate;
    private Date vBegindate;
    private String vPhone;
    private Double vAcount;
    private Double vSum;
    private Integer vState;
    private Integer vIdc;
    private Double vDiscount;
    private String vGrade;
    private String vDisplay;
    private Double vLimit;

    @Override
    public String toString() {
        return "VipVO{" +
                "vPassword=" + vPassword +
                ", vPpassword=" + vPpassword +
                ", vid=" + vid +
                ", vName='" + vName + '\'' +
                ", vCount='" + vCount + '\'' +
                ", oPrice=" + oPrice +
                ", oDate=" + oDate +
                ", vBegindate=" + vBegindate +
                ", vPhone='" + vPhone + '\'' +
                ", vAcount=" + vAcount +
                ", vSum=" + vSum +
                ", vState=" + vState +
                ", vIdc=" + vIdc +
                ", vDiscount=" + vDiscount +
                ", vGrade='" + vGrade + '\'' +
                ", vDisplay='" + vDisplay + '\'' +
                ", vLimit=" + vLimit +
                '}';
    }

    public int getvPassword() {
        return vPassword;
    }

    public void setvPassword(int vPassword) {
        this.vPassword = vPassword;
    }

    public int getvPpassword() {
        return vPpassword;
    }

    public void setvPpassword(int vPpassword) {
        this.vPpassword = vPpassword;
    }

    public Double getvLimit() {
        return vLimit;
    }

    public void setvLimit(Double vLimit) {
        this.vLimit = vLimit;
    }

    public Date getoDate() {
        return oDate;
    }

    public void setoDate(Date oDate) {
        this.oDate = oDate;
    }

    public double getoPrice() {
        return oPrice;
    }

    public void setoPrice(double oPrice) {
        this.oPrice = oPrice;
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

    public Integer getvIdc() {
        return vIdc;
    }

    public void setvIdc(Integer vIdc) {
        this.vIdc = vIdc;
    }

    public Double getvDiscount() {
        return vDiscount;
    }

    public void setvDiscount(Double vDiscount) {
        this.vDiscount = vDiscount;
    }

    public String getvGrade() {
        return vGrade;
    }

    public void setvGrade(String vGrade) {
        this.vGrade = vGrade;
    }

    public String getvDisplay() {
        return vDisplay;
    }

    public void setvDisplay(String vDisplay) {
        this.vDisplay = vDisplay;
    }

    public Double getvSum() {
        return vSum;
    }

    public void setvSum(Double vSum) {
        this.vSum = vSum;
    }
}
