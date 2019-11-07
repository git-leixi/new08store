package com.aaa.store08.entity;

import java.util.List;

public class DataGrid {
	
	private Integer code; //不需要
	private Integer count;//行数
	private List  data;//数据
	private String msg;//不需要
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "DataGrid [code=" + code + ", count=" + count + ", data=" + data
				+ ", msg=" + msg + "]";
	}
	
	

}
