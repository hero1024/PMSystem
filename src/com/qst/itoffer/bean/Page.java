package com.qst.itoffer.bean;

import java.io.Serializable;
import java.util.List;


public class Page implements Serializable{
	
	//Ŀǰ����ҳ��
	private int currentPageIndex;
	
	//�ܹ��ж���ҳ
	private int pagecount;
	
	//ÿһҳ��ʾ��������
	private int count=5;
	
	//�ܹ��ж�������
	private int totalDataCount;
	
	//��װ��һ��ҳ���list
	private List<Staff> list  = null;
	
	

	public int getCurrentPageIndex() {
		return currentPageIndex;
	}
	
	public Page(int totalCount,int count){
		this.totalDataCount = totalCount;
		this.count = count;
		
		//�����ܹ��ж���ҳ
	    pagecount = (totalCount + count -1)/count;
	}
	
	
	public List<Staff> getList() {
		return list;
	}

	public void setList(List<Staff> list) {
		this.list = list;
	}

	public void setCurrentPageIndex(int currentPageIndex) {
		this.currentPageIndex = currentPageIndex;
	}

	public int getPagecount() {
		return pagecount;
	}

	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotalDataCount() {
		return totalDataCount;
	}

	public void setTotalDataCount(int totalDataCount) {
		this.totalDataCount = totalDataCount;
	}

	
	
	

}