package com.aaa.store08.entity;

import java.io.Serializable;

public class Food implements Serializable {
    private Integer mId;
    private String mName;
    private String mPrice;
    private String mImg;
    private Integer mKind;
    private Integer mArea;
    private String aName;
    private String aMain;
    private String kName;
    private Integer tId;
    private Integer tArea;
    private Integer tKind;
    private Integer kId;

    @Override
    public String toString() {
        return "Food{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mPrice='" + mPrice + '\'' +
                ", mImg='" + mImg + '\'' +
                ", mKind=" + mKind +
                ", mArea=" + mArea +
                ", aName='" + aName + '\'' +
                ", aMain='" + aMain + '\'' +
                ", kName='" + kName + '\'' +
                ", tId=" + tId +
                ", tArea=" + tArea +
                ", tKind=" + tKind +
                ", kId=" + kId +
                '}';
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPrice() {
        return mPrice;
    }

    public void setmPrice(String mPrice) {
        this.mPrice = mPrice;
    }

    public String getmImg() {
        return mImg;
    }

    public void setmImg(String mImg) {
        this.mImg = mImg;
    }

    public Integer getmKind() {
        return mKind;
    }

    public void setmKind(Integer mKind) {
        this.mKind = mKind;
    }

    public Integer getmArea() {
        return mArea;
    }

    public void setmArea(Integer mArea) {
        this.mArea = mArea;
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

    public String getkName() {
        return kName;
    }

    public void setkName(String kName) {
        this.kName = kName;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public Integer gettArea() {
        return tArea;
    }

    public void settArea(Integer tArea) {
        this.tArea = tArea;
    }

    public Integer gettKind() {
        return tKind;
    }

    public void settKind(Integer tKind) {
        this.tKind = tKind;
    }

    public Integer getkId() {
        return kId;
    }

    public void setkId(Integer kId) {
        this.kId = kId;
    }
}
