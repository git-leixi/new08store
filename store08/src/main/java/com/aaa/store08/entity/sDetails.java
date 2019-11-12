package com.aaa.store08.entity;

import java.io.Serializable;

public class sDetails implements Serializable {
    private String odname;   //商品名称
    private String odaName; //窗口名称
    private double odprice; //菜品价格
    private int odNum;  //点菜数量
    private String vphone;//vip手机号
    private double oyprice;  //优惠价格
    private double ocprice; // 总价
    private double oprice; //实收金额
    private String odesk; //桌号
    private double vBalance; //余额
    private double vAcount; //余额
    private String vname; //会员名
    private String vCount;//会员编号
    private String vGrade;  //会员等级
    private double vDiscount;  //折扣力度
    private String vDisplay;  //数值
    private String payment; //付款状态
    private int vid;
    private  int odid;

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

    public double getOdprice() {
        return odprice;
    }

    public void setOdprice(double odprice) {
        this.odprice = odprice;
    }

    public int getOdNum() {
        return odNum;
    }

    public void setOdNum(int odNum) {
        this.odNum = odNum;
    }

    public String getVphone() {
        return vphone;
    }

    public void setVphone(String vphone) {
        this.vphone = vphone;
    }

    public double getOyprice() {
        return oyprice;
    }

    public void setOyprice(double oyprice) {
        this.oyprice = oyprice;
    }

    public double getOcprice() {
        return ocprice;
    }

    public void setOcprice(double ocprice) {
        this.ocprice = ocprice;
    }

    public double getOprice() {
        return oprice;
    }

    public void setOprice(double oprice) {
        this.oprice = oprice;
    }

    public String getOdesk() {
        return odesk;
    }

    public void setOdesk(String odesk) {
        this.odesk = odesk;
    }

    public double getvBalance() {
        return vBalance;
    }

    public void setvBalance(double vBalance) {
        this.vBalance = vBalance;
    }

    public double getvAcount() {
        return vAcount;
    }

    public void setvAcount(double vAcount) {
        this.vAcount = vAcount;
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

    public double getvDiscount() {
        return vDiscount;
    }

    public void setvDiscount(double vDiscount) {
        this.vDiscount = vDiscount;
    }

    public String getvDisplay() {
        return vDisplay;
    }

    public void setvDisplay(String vDisplay) {
        this.vDisplay = vDisplay;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public int getOdid() {
        return odid;
    }

    public void setOdid(int odid) {
        this.odid = odid;
    }


    @Override
    public String toString() {
        return "sDetails{" +
                "odname='" + odname + '\'' +
                ", odaName='" + odaName + '\'' +
                ", odprice=" + odprice +
                ", odNum=" + odNum +
                ", vphone='" + vphone + '\'' +
                ", oyprice=" + oyprice +
                ", ocprice=" + ocprice +
                ", oprice=" + oprice +
                ", odesk='" + odesk + '\'' +
                ", vBalance=" + vBalance +
                ", vAcount=" + vAcount +
                ", vname='" + vname + '\'' +
                ", vCount='" + vCount + '\'' +
                ", vGrade='" + vGrade + '\'' +
                ", vDiscount=" + vDiscount +
                ", vDisplay='" + vDisplay + '\'' +
                ", payment='" + payment + '\'' +
                ", vid=" + vid +
                ", odid=" + odid +
                '}';
    }
}
