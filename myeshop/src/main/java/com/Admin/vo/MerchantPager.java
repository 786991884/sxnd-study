package com.Admin.vo;

import java.util.Map;

public class MerchantPager {
	private Map merchantMap;
	private int totalNum;
	private int pageSize;
	private int pagecurrentPageNo;
	private int pageNum;
	private int pageOffset;

	public Map getMerchantMap() {
		return merchantMap;
	}

	public void setMerchantMap(Map merchantMap) {
		this.merchantMap = merchantMap;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPagecurrentPageNo() {
		return pagecurrentPageNo;
	}

	public void setPagecurrentPageNo(int pagecurrentPageNo) {
		this.pagecurrentPageNo = pagecurrentPageNo;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageOffset() {
		return pageOffset;
	}

	public void setPageOffset(int pageOffset) {
		this.pageOffset = pageOffset;
	}

}
