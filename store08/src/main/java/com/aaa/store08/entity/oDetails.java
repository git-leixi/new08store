package com.aaa.store08.entity;

import java.io.Serializable;

public class oDetails implements Serializable {
    private int odId;   //
    private String odName;   //商品名称
    private int odPrice;   //商品价格
    private  String odaName;   //窗口名称
    private int odaid;   //窗口id
    private int odNum;   //商品数量
    private int odoId;   //订单id
    private String payment; //付款状态

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public int getOdId() {
        return odId;
    }

    public void setOdId(int odId) {
        this.odId = odId;
    }

    public String getOdName() {
        return odName;
    }

    public void setOdName(String odName) {
        this.odName = odName;
    }

    public int getOdPrice() {
        return odPrice;
    }

    public void setOdPrice(int odPrice) {
        this.odPrice = odPrice;
    }

    public String getOdaName() {
        return odaName;
    }

    public void setOdaName(String odaName) {
        this.odaName = odaName;
    }

    public int getOdaid() {
        return odaid;
    }

    public void setOdaid(int odaid) {
        this.odaid = odaid;
    }

    public int getOdNum() {
        return odNum;
    }

    public void setOdNum(int odNum) {
        this.odNum = odNum;
    }

    public int getOdoId() {
        return odoId;
    }

    public void setOdoId(int odoId) {
        this.odoId = odoId;
    }
}
