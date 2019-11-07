package com.aaa.store08.entity;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private Integer oId;  //编号
    private Date oDate;     //日期
    private String oDesk;   // 桌号
    private String oPrice;  //价格
    private Integer mId;  // 菜品
    private Integer oArea; //区域
    private String oNewDate; // 转换后的日期

    public String getoNewDate() {
        return oNewDate;
    }

    public void setoNewDate(String oNewDate) {
        this.oNewDate = oNewDate;
    }

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public Date getoDate() {
        return oDate;
    }

    public void setoDate(Date oDate) {
        this.oDate = oDate;
    }

    public String getoDesk() {
        return oDesk;
    }

    public void setoDesk(String oDesk) {
        this.oDesk = oDesk;
    }

    public String getoPrice() {
        return oPrice;
    }

    public void setoPrice(String oPrice) {
        this.oPrice = oPrice;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public Integer getoArea() {
        return oArea;
    }

    public void setoArea(Integer oArea) {
        this.oArea = oArea;
    }
}
