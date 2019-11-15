package com.aaa.store08.entity;

import java.io.Serializable;
import java.util.Date;

public class Vbills implements Serializable {
    private Integer vBid;
    private Double vBalance;
    private Date vBillsdate;
    private String vComment;
    private Integer vid;
    private Integer  vidc;
    private Integer vOrders;

    public Integer getvBid() {
        return vBid;
    }

    public void setvBid(Integer vBid) {
        this.vBid = vBid;
    }

    public Double getvBalance() {
        return vBalance;
    }

    public void setvBalance(Double vBalance) {
        this.vBalance = vBalance;
    }

    public Date getvBillsdate() {
        return vBillsdate;
    }

    public void setvBillsdate(Date vBillsdate) {
        this.vBillsdate = vBillsdate;
    }

    public String getvComment() {
        return vComment;
    }

    public void setvComment(String vComment) {
        this.vComment = vComment;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public Integer getVidc() {
        return vidc;
    }

    public void setVidc(Integer vidc) {
        this.vidc = vidc;
    }

    public Integer getvOrders() {
        return vOrders;
    }

    public void setvOrders(Integer vOrders) {
        this.vOrders = vOrders;
    }
}
