package com.aaa.store08.entity;

import java.io.Serializable;

public class vIn implements Serializable {
    private int vid;
    private int vIdc;
    private double vSum;

    @Override
    public String toString() {
        return "vIn{" +
                "vid=" + vid +
                ", vIdc=" + vIdc +
                ", vSum=" + vSum +
                '}';
    }

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public int getvIdc() {
        return vIdc;
    }

    public void setvIdc(int vIdc) {
        this.vIdc = vIdc;
    }

    public double getvSum() {
        return vSum;
    }

    public void setvSum(double vSum) {
        this.vSum = vSum;
    }
}
