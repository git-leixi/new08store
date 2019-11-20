package com.aaa.store08.entity;

public class PageVo {
	

	private Integer limit;//数据量
	private Integer page;//页码数
	private Integer aid;

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	@Override
	public String toString() {
		return "PageVo [limit=" + limit + ", page=" + page + "]";
	}
	
	
}
