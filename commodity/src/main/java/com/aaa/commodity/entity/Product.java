package com.aaa.commodity.entity;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable {
    private Integer Productid;
    private String productname;
    private Double Productprice;
    private Date Producttime;
    private Date Buytime;
    private Integer Catagoryid;

    public Integer getProductid() {
        return Productid;
    }

    public void setProductid(Integer productid) {
        Productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Double getProductprice() {
        return Productprice;
    }

    public void setProductprice(Double productprice) {
        Productprice = productprice;
    }

    public Date getProducttime() {
        return Producttime;
    }

    public void setProducttime(Date producttime) {
        Producttime = producttime;
    }

    public Date getBuytime() {
        return Buytime;
    }

    public void setBuytime(Date buytime) {
        Buytime = buytime;
    }

    public Integer getCatagoryid() {
        return Catagoryid;
    }

    public void setCatagoryid(Integer catagoryid) {
        Catagoryid = catagoryid;
    }
}
