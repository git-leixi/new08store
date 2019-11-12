package com.aaa.store08.entity;

import java.io.Serializable;
import java.util.Date;

public class OrdersDetails implements Serializable {
    private int odId;   //
    private String odName;   //商品名称
    private int odPrice;   //商品价格
    private  String odaName;   //窗口名称
    private int odaid;   //窗口id
    private int odNum;   //商品数量
    private int odoId;   //订单id
    private String payment; //付款状态
    private Integer oId;
    private Date oDate;
    private String oDesk;
    private Integer oPrice;
    private Integer oArea;
    private Integer oyPrice;
    private Integer ocPrice;
    private String vPhone;

    @Override
    public String toString() {
        return "OrdersDetails{" +
                "odId=" + odId +
                ", odName='" + odName + '\'' +
                ", odPrice=" + odPrice +
                ", odaName='" + odaName + '\'' +
                ", odaid=" + odaid +
                ", odNum=" + odNum +
                ", odoId=" + odoId +
                ", payment='" + payment + '\'' +
                ", oId=" + oId +
                ", oDate=" + oDate +
                ", oDesk='" + oDesk + '\'' +
                ", oPrice=" + oPrice +
                ", oArea=" + oArea +
                ", oyPrice=" + oyPrice +
                ", ocPrice=" + ocPrice +
                ", vPhone='" + vPhone + '\'' +
                '}';
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

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
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

    public Integer getoPrice() {
        return oPrice;
    }

    public void setoPrice(Integer oPrice) {
        this.oPrice = oPrice;
    }

    public Integer getoArea() {
        return oArea;
    }

    public void setoArea(Integer oArea) {
        this.oArea = oArea;
    }

    public Integer getOyPrice() {
        return oyPrice;
    }

    public void setOyPrice(Integer oyPrice) {
        this.oyPrice = oyPrice;
    }

    public Integer getOcPrice() {
        return ocPrice;
    }

    public void setOcPrice(Integer ocPrice) {
        this.ocPrice = ocPrice;
    }

    public String getvPhone() {
        return vPhone;
    }

    public void setvPhone(String vPhone) {
        this.vPhone = vPhone;
    }
}
