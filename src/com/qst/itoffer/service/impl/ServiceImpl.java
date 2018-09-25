package com.qst.itoffer.service.impl;

import java.util.List;

import com.qst.itoffer.bean.Page;
import com.qst.itoffer.bean.Staff;
import com.qst.itoffer.service.Service;
import com.qst.itoffer.dao.Dao;
import com.qst.itoffer.dao.impl.DaoImpl;


public class ServiceImpl implements Service {

	Dao dao = new DaoImpl();
	
	@Override
	public Staff login(String username, String password) {
		Staff staff = new Staff();
		staff = dao.findUserByUsernameAndPassword(username, password);
		if(staff!=null)
			return staff;
		return null;
	}

	@Override
	public Staff check(String username) {
		Staff staff = new Staff();
		staff = dao.findUserByUsername(username);
		if(staff!=null)
			return staff;
		return null;
	}

	@Override
	public int addUser(Staff staff) {
		int n = dao.addUser(staff);
		return n;
	}
	
	@Override
	public int updatePassword(String username, String password) {
		// TODO Auto-generated method stub
		int n = dao.updatePassword(username, password);
		return n;
	}

	@Override
	public int getPageCount(int count) {
		int totalCount = dao.getTotalCount();
		return (totalCount+count-1)/count;
	}
	
	@Override
	public Page getPageList(int currentPageIndex, int count) {
		
		int totalCount = dao.getTotalCount();
		
		Page page = new Page(totalCount,count);
		
		page.setList(dao.getPageList(currentPageIndex, count));
		
		return page;
	}
	
	@Override
	public Page getPageList2(int currentPageIndex, int count) {
		
		int totalCount = dao.getTotalCount();
		
		Page page2 = new Page(totalCount,count);
		
		page2.setList(dao.getPageList2(currentPageIndex, count));
		
		return page2;
	}
	
	@Override
	public Page getPageList3(int currentPageIndex, int count) {
		
		int totalCount = dao.getTotalCount();
		
		Page page3 = new Page(totalCount,count);
		
		page3.setList(dao.getPageList3(currentPageIndex, count));
		
		return page3;
	}
	
	@Override
	public int deleteStaffById(String id) {
		// TODO Auto-generated method stub
		return dao.deleteStaffById(id);
	}
	
	@Override
	public Staff findStaffById(String id) {
		// TODO Auto-generated method stub
		return dao.findStaffById(id);
	}
	
	@Override
	public Staff findStaffById2(String id) {
		// TODO Auto-generated method stub
		return dao.findStaffById2(id);
	}
	
	@Override
	public Staff findStaffById3(String id) {
		// TODO Auto-generated method stub
		return dao.findStaffById3(id);
	}
	
	@Override
	public int addStaff(Staff sta) {
		// TODO Auto-generated method stub
		return dao.addStaff(sta);
	}
	
	@Override
	public int addStaff2(Staff sta) {
		// TODO Auto-generated method stub
		return dao.addStaff2(sta);
	}
	
	@Override
	public Page getPageListByName(int currentPageIndex, int count, String name) {
        int totalCount = dao.getTotalNameStaff(name);
		
		Page page = new Page(totalCount,count);
		
		page.setList(dao.findPageListByName(currentPageIndex, count, name));
		
		return page;
	}
	
	@Override
	public Page getPageListByName2(int currentPageIndex, int count, String name) {
        int totalCount = dao.getTotalNameStaff(name);
		
		Page page = new Page(totalCount,count);
		
		page.setList(dao.findPageListByName2(currentPageIndex, count, name));
		
		return page;
	}
	
	@Override
	public Page getPageListByName3(int currentPageIndex, int count, String name) {
        int totalCount = dao.getTotalNameStaff(name);
		
		Page page = new Page(totalCount,count);
		
		page.setList(dao.findPageListByName3(currentPageIndex, count, name));
		
		return page;
	}
	
	@Override
	public int getNamePageCount(int count, String name) {
		int totalCount = dao.getTotalNameStaff(name);
		return (totalCount + count -1 )/count;
	}
	
	@Override
	public int updateStaffById(String id, Staff sta) {
		return dao.updateStaffById(id, sta);
	}
	
	@Override
	public int updateUserRole(String username, String role) {
		// TODO Auto-generated method stub
		return dao.updateUserRole(username, role);
	}
	
	@Override
	public List<Staff> getAllUser() {
		// TODO Auto-generated method stub
		return dao.getAllUser();
	}

	/*@Override
	public int addUser(Staff staff) {
		// TODO Auto-generated method stub
		return 0;
	}*/
	
	@Override
	public int updateStaffInfoById(String id, Staff sta) {
		// TODO Auto-generated method stub
		return dao.updateStaffInfoById(id, sta);
	}
	
	@Override
	public int updateRole(String id, String role) {
		// TODO Auto-generated method stub
		return dao.updateRole(id, role);
	}
}
