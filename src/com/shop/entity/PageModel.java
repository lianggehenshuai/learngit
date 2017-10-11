package com.shop.entity;

import java.util.List;

/**
 * ·â×°·ÖÒ³
 * @author Administrator
 *
 */
public class PageModel<T> {

	public PageModel() {
		// TODO Auto-generated constructor stub
	}

	
	private int counts;
	
	private List<T> pageInfo;
	
	private int allPages;
	
	private int currentPageNo;

	public int getCounts() {
		return counts;
	}

	public void setCounts(int counts) {
		this.counts = counts;
	}

	

	public List<T> getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(List<T> pageInfo) {
		this.pageInfo = pageInfo;
	}

	public int getAllPages() {
		return allPages;
	}

	public void setAllPages(int allPages) {
		this.allPages = allPages;
	}

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}
	
	
}
