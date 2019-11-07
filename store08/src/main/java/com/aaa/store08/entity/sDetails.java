package com.aaa.store08.entity;

import java.io.Serializable;

public class sDetails implements Serializable {
    private String odname;   //商品名称
    private String odaName; //窗口名称
    private int odprice; //菜品价格
    private String vphone;//vip手机号
    private Double oyprice;  //优惠价格
    private Double ocprice; // 总价
    private Double oprice; //实收金额
    private String odesk; //桌号
    private Double vBalance; //余额
    private String vname; //会员名
    private String vCount;//会员编号
    private String vGrade;  //会员等级
    private Double vDiscount;  //折扣力度
    private String vDisplay;  //数值
    private String payment; //付款状态

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getOdname() {
        return odname;
    }

    public void setOdname(String odname) {
        this.odname = odname;
    }

    public String getOdaName() {
        return odaName;
    }

    public void setOdaName(String odaName) {
        this.odaName = odaName;
    }

    public int getOdprice() {
        return odprice;
    }

    public void setOdprice(int odprice) {
        this.odprice = odprice;
    }

    public String getVphone() {
        return vphone;
    }

    public void setVphone(String vphone) {
        this.vphone = vphone;
    }



    public String getOdesk() {
        return odesk;
    }

    public void setOdesk(String odesk) {
        this.odesk = odesk;
    }


    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getvCount() {
        return vCount;
    }

    public void setvCount(String vCount) {
        this.vCount = vCount;
    }

    public String getvGrade() {
        return vGrade;
    }

    public void setvGrade(String vGrade) {
        this.vGrade = vGrade;
    }

    public Double getvDiscount() {
        return vDiscount;
    }

    public void setvDiscount(Double vDiscount) {
        this.vDiscount = vDiscount;
    }

    public String getvDisplay() {
        return vDisplay;
    }

    public void setvDisplay(String vDisplay) {
        this.vDisplay = vDisplay;
    }

    public Double getOyprice() {
        return oyprice;
    }

    public void setOyprice(Double oyprice) {
        this.oyprice = oyprice;
    }

    public Double getOcprice() {
        return ocprice;
    }

    public void setOcprice(Double ocprice) {
        this.ocprice = ocprice;
    }

    public Double getOprice() {
        return oprice;
    }

    public void setOprice(Double oprice) {
        this.oprice = oprice;
    }

    public Double getvBalance() {
        return vBalance;
    }

    public void setvBalance(Double vBalance) {
        this.vBalance = vBalance;
    }

    @Override
    public String toString() {
        return "sDetails{" +
                "odname='" + odname + '\'' +
                ", odaName='" + odaName + '\'' +
                ", odprice=" + odprice +
                ", vphone='" + vphone + '\'' +
                ", oyprice=" + oyprice +
                ", ocprice=" + ocprice +
                ", oprice=" + oprice +
                ", odesk='" + odesk + '\'' +
                ", vBalance=" + vBalance +
                ", vname='" + vname + '\'' +
                ", vCount='" + vCount + '\'' +
                ", vGrade='" + vGrade + '\'' +
                ", vDiscount=" + vDiscount +
                ", vDisplay='" + vDisplay + '\'' +
                ", payment='" + payment + '\'' +
                '}';
    }
}
