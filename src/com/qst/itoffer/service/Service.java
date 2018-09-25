package com.qst.itoffer.service;

import java.util.List;

import com.qst.itoffer.bean.Staff;
import com.qst.itoffer.bean.Page;

public interface Service {


    public Staff login(String username,String password);
	
	public Staff check(String username);
	
	public int addUser(Staff staff);
	
	public int updatePassword(String username, String password);
	
	public Staff findStaffById(String id);
	
	public Staff findStaffById2(String id);
	
	public Staff findStaffById3(String id);
	
	public int addStaff(Staff sta);
	
	public int addStaff2(Staff sta);
	
	public int deleteStaffById(String id);
	
	public int getPageCount(int count);
	
	public Page getPageList(int currentPageIndex,int count);
	
	public Page getPageList2(int currentPageIndex,int count);
	
	public Page getPageList3(int currentPageIndex,int count);
	
	public int getNamePageCount(int count,String name);
	
	public Page getPageListByName(int currentPageIndex,int count,String name);
	
	public Page getPageListByName2(int currentPageIndex,int count,String name);
	
	public Page getPageListByName3(int currentPageIndex,int count,String name);

	public int updateStaffById(String id, Staff sta);
	
	public int updateUserRole(String username, String role);
	
	public List<Staff> getAllUser();
	
	public int updateStaffInfoById(String id, Staff sta);
	
	public int updateRole(String id, String role);
	
}
