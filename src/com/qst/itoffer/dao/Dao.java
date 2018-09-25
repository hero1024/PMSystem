package com.qst.itoffer.dao;

import java.util.Date;
import java.util.List;

import com.qst.itoffer.bean.Staff;

public interface Dao {
	
	public int updatePassword(String username, String password);
	
	public Staff findUserByUsernameAndPassword(String username,String password);

	public Staff findUserByUsername(String username);

	public int addUser(Staff staff);
	
	public int getTotalCount();
	
	public List<Staff> getPageList(int currentPageIndex,int count);
	
	public List<Staff> getPageList2(int currentPageIndex,int count);
	
	public List<Staff> getPageList3(int currentPageIndex,int count);
	
	public int deleteStaffById(String id);
	
	public Staff findStaffById(String id);
	
	public Staff findStaffById2(String id);
	
	public Staff findStaffById3(String id);
	
	public int addStaff(Staff sta);
	
	public int addStaff2(Staff sta);
	
	public int getTotalNameStaff(String name);
	
	public List<Staff> findPageListByName(int currentPageIndex,int count,String name);
	
	public List<Staff> findPageListByName2(int currentPageIndex,int count,String name);
	
	public List<Staff> findPageListByName3(int currentPageIndex,int count,String name);
	
	public int updateStaffById(String id,Staff sta);
	
	public List<Staff> getAllUser();
	
	public int updateUserRole(String username, String role);
	
	public int updateStaffInfoById(String id,Staff sta);
	
	public int updateRole(String id,String role);

}
