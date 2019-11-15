package com.aaa.store08.entity;

import java.io.Serializable;

public class VipType implements Serializable {
    private Integer vIdc;
    private Double vDiscount;
    private String vGrade;
    private String vDisplay;
    private Double vLimit;

    @Override
    public String toString() {
        return "VipType{" +
                "vIdc=" + vIdc +
                ", vDiscount=" + vDiscount +
                ", vGrade='" + vGrade + '\'' +
                ", vDisplay='" + vDisplay + '\'' +
                ", vLimit=" + vLimit +
                '}';
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

    public Double getvLimit() {
        return vLimit;
    }

    public void setvLimit(Double vLimit) {
        this.vLimit = vLimit;
    }
}
