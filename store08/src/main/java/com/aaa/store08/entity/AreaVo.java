package com.aaa.store08.entity;

import java.io.Serializable;

public class AreaVo implements Serializable {
      private Integer aId;
      private String aName;
      private String aMain;
      private Integer dId;
      private String dName;
      private String dArea;
      private String dsort;
      private String dimg;

      public String getDimg() {
            return dimg;
      }

      public void setDimg(String dimg) {
            this.dimg = dimg;
      }

      @Override
      public String toString() {
            return "AreaVo{" +
                    "aId=" + aId +
                    ", aName='" + aName + '\'' +
                    ", aMain='" + aMain + '\'' +
                    ", dId=" + dId +
                    ", dName='" + dName + '\'' +
                    ", dArea='" + dArea + '\'' +
                    ", dsort='" + dsort + '\'' +
                    '}';
      }

      public String getDsort() {
            return dsort;
      }

      public void setDsort(String dsort) {
            this.dsort = dsort;
      }

      public Integer getaId() {
            return aId;
      }

      public void setaId(Integer aId) {
            this.aId = aId;
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

      public Integer getdId() {
            return dId;
      }

      public void setdId(Integer dId) {
            this.dId = dId;
      }

      public String getdName() {
            return dName;
      }

      public void setdName(String dName) {
            this.dName = dName;
      }

      public String getdArea() {
            return dArea;
      }

      public void setdArea(String dArea) {
            this.dArea = dArea;
      }
}
