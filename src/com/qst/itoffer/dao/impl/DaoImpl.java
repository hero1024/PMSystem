package com.qst.itoffer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qst.itoffer.bean.Staff;

import java.util.ArrayList;
import java.util.List;

import com.qst.itoffer.dao.Dao;
import com.qst.itoffer.utils.JdbcUtils;


public class DaoImpl implements Dao {

	@Override
	public int updatePassword(String username, String password) {
		// TODO Auto-generated method stub
		try {
			Connection conn = JdbcUtils.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("update staffinfo set password=? where username=?");
			
			pstmt.setString(1, password);
			pstmt.setString(2, username);
			
			int n = pstmt.executeUpdate();
			JdbcUtils.relase(null, pstmt, conn);
			return n;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public Staff findUserByUsernameAndPassword(String username, String password) {
		try {
			Connection conn = JdbcUtils.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from staffinfo where username=? and password=?");
			ResultSet rs = null;
			
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				Staff staff = new Staff();
				
				staff.setId(rs.getString("id"));
				staff.setUsername(rs.getString("username"));
				staff.setPassword(rs.getString("password"));
				staff.setName(rs.getString("name"));
				staff.setSex(rs.getString("sex"));
				staff.setDepartment(rs.getString("department"));
				staff.setLocation(rs.getString("location"));
				staff.setBusinessgrade(rs.getString("businessgrade"));
				staff.setBehaviorgrade(rs.getString("behaviorgrade"));
				staff.setSalary(rs.getString("salary"));
				staff.setReward(rs.getString("reward"));
				staff.setRole(rs.getString("role"));
				
			    return staff;
				
			}
			
			//�ͷ���Դ
			JdbcUtils.relase(rs, pstmt, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public Staff findUserByUsername(String username) {
		
		try {
			Connection conn = JdbcUtils.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from staffinfo where username=?");
			ResultSet rs = null;
			
			pstmt.setString(1, username);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
                Staff staff = new Staff();
				
				staff.setUsername(rs.getString("username"));
				staff.setPassword(rs.getString("password"));
				staff.setRole(rs.getString("role"));
				
			    return staff;
			}
			
			//�ͷ���Դ
			JdbcUtils.relase(rs, pstmt, conn);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public int addUser(Staff staff){
		try {
			Connection conn = JdbcUtils.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("insert into staffinfo(username,password,role) values(?,?,'staff')");
			
			pstmt.setString(1, staff.getUsername());
			pstmt.setString(2, staff.getPassword());
			int n = pstmt.executeUpdate();
			
			
			//�ͷ���Դ
			JdbcUtils.relase(null, pstmt, conn);
			return n;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int getTotalCount() {
		try {
			Connection conn = JdbcUtils.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select count(*) from staffinfo");
			ResultSet rs = null;
			
			
			rs = pstmt.executeQuery();
			int n=0;
			
			if(rs.next())
				n= rs.getInt(1);
			JdbcUtils.relase(null, pstmt, conn);
			
			return n;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Staff> getPageList2(int currentPageIndex, int count) {
		try {
			Connection conn = JdbcUtils.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from staffinfo order by id limit ?,?");
			ResultSet rs = null;
			
			
			pstmt.setInt(1, count*(currentPageIndex-1));
			pstmt.setInt(2, count);
			
			rs = pstmt.executeQuery();
			
			List<Staff> list = new ArrayList<Staff>();
			
			while(rs.next()){
                Staff sta = new Staff();
				
				sta.setId(rs.getString("id"));
				sta.setName(rs.getString("name"));
				sta.setBusinessgrade(rs.getString("businessgrade"));
				sta.setBehaviorgrade(rs.getString("behaviorgrade"));
				
				list.add(sta);
				
			}
            JdbcUtils.relase(rs, pstmt, conn);
			
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Staff> getPageList3(int currentPageIndex, int count) {
		try {
			Connection conn = JdbcUtils.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from staffinfo order by id limit ?,?");
			ResultSet rs = null;
			
			
			pstmt.setInt(1, count*(currentPageIndex-1));
			pstmt.setInt(2, count);
			
			rs = pstmt.executeQuery();
			
			List<Staff> list = new ArrayList<Staff>();
			
			while(rs.next()){
                Staff sta = new Staff();
				
				sta.setId(rs.getString("id"));
				sta.setName(rs.getString("name"));
				sta.setSalary(rs.getString("salary"));
				sta.setReward(rs.getString("reward"));
				
				list.add(sta);
				
			}
            JdbcUtils.relase(rs, pstmt, conn);
			
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Staff> getPageList(int currentPageIndex, int count) {
		try {
			Connection conn = JdbcUtils.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from staffinfo order by id limit ?,?");
			ResultSet rs = null;
			
			
			pstmt.setInt(1, count*(currentPageIndex-1));
			pstmt.setInt(2, count);
			
			rs = pstmt.executeQuery();
			
			List<Staff> list = new ArrayList<Staff>();
			
			while(rs.next()){
                Staff sta = new Staff();
				
				sta.setId(rs.getString("id"));
				sta.setName(rs.getString("name"));
				sta.setSex(rs.getString("sex"));
				sta.setDepartment(rs.getString("department"));
				sta.setLocation(rs.getString("location"));
				
				list.add(sta);
				
			}
            JdbcUtils.relase(rs, pstmt, conn);
			
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int deleteStaffById(String id) {
		try {
			Connection conn = JdbcUtils.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("delete from staffinfo where id=?");
			
			pstmt.setString(1, id);
			
		    int n = pstmt.executeUpdate();
		    JdbcUtils.relase(null, pstmt, conn);
		    return n;
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public Staff findStaffById(String id) {
		try {
			Connection conn = JdbcUtils.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from staffinfo where id=?");
			ResultSet rs = null;
			
			pstmt.setString(1, id);
			
			rs  =pstmt.executeQuery();
			
			if(rs.next()){
				
				Staff staff = new Staff();
				
				staff.setId(rs.getString("id"));
				staff.setUsername(rs.getString("username"));
				staff.setPassword(rs.getString("password"));
				staff.setName(rs.getString("name"));
				staff.setSex(rs.getString("sex"));
				staff.setDepartment(rs.getString("department"));
				staff.setLocation(rs.getString("location"));
				staff.setBusinessgrade(rs.getString("businessgrade"));
				staff.setBehaviorgrade(rs.getString("behaviorgrade"));
				staff.setSalary(rs.getString("salary"));
				staff.setReward(rs.getString("reward"));
				staff.setRole(rs.getString("role"));
				
//				sta.setId(rs.getString("id"));
//				sta.setName(rs.getString("name"));
//				sta.setSex(rs.getString("sex"));
//				sta.setDepartment(rs.getString("department"));
//				sta.setLocation(rs.getString("location"));
				
				return staff;
			}
			 JdbcUtils.relase(rs, pstmt, conn);
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Staff findStaffById2(String id) {
		try {
			Connection conn = JdbcUtils.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from staffinfo where id=?");
			ResultSet rs = null;
			
			pstmt.setString(1, id);
			
			rs  =pstmt.executeQuery();
			
			if(rs.next()){
				
				Staff sta = new Staff();
				
				sta.setId(rs.getString("id"));
				sta.setName(rs.getString("name"));
				sta.setBusinessgrade(rs.getString("businessgrade"));
				sta.setBehaviorgrade(rs.getString("behaviorgrade"));
				
				return sta;
			}
			 JdbcUtils.relase(rs, pstmt, conn);
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Staff findStaffById3(String id) {
		try {
			Connection conn = JdbcUtils.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from staffinfo where id=?");
			ResultSet rs = null;
			
			pstmt.setString(1, id);
			
			rs  =pstmt.executeQuery();
			
			if(rs.next()){
				
				Staff sta = new Staff();
				
				sta.setId(rs.getString("id"));
				sta.setName(rs.getString("name"));
				sta.setSalary(rs.getString("salary"));
				sta.setReward(rs.getString("reward"));
				
				return sta;
			}
			 JdbcUtils.relase(rs, pstmt, conn);
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	

	@Override
	public int addStaff(Staff sta) {
		try {
			Connection conn = JdbcUtils.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("insert into staffinfo(id,username,password,name,sex,department,location,businessgrade,behaviorgrade,salary,reward) values(?,?,?,?,?,?,?,?,?,?,?)");
			//PreparedStatement pstmt1 = conn.prepareStatement("insert into login(username,password,role) values(?,?,'staff')");
			
			pstmt.setString(1, sta.getId());
			pstmt.setString(2, sta.getUsername());
			pstmt.setString(3, sta.getPassword());
			pstmt.setString(4, sta.getName());
			pstmt.setString(5, sta.getSex());
			pstmt.setString(6, sta.getDepartment());
			pstmt.setString(7, sta.getLocation());
			pstmt.setString(8, sta.getBusinessgrade());
			pstmt.setString(9, sta.getBehaviorgrade());
			pstmt.setString(10, sta.getSalary());
			pstmt.setString(11, sta.getReward());
			
			//pstmt1.setString(1, sta.getUsername());
			//pstmt1.setString(2, sta.getPassword());
			
			int n = pstmt.executeUpdate();
			JdbcUtils.relase(null, pstmt, conn);
			return n;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public int addStaff2(Staff sta) {
		try {
			Connection conn = JdbcUtils.getConnection();
			//PreparedStatement pstmt = conn.prepareStatement("insert into staffinfo(id,username,password,name,sex,department,location) values(?,?,?,?,?,?,?)");
			PreparedStatement pstmt1 = conn.prepareStatement("insert into staffinfo(username,password,role) values(?,?,'staff')");
			
			//pstmt.setString(1, sta.getId());
			//pstmt.setString(2, sta.getUsername());
			//pstmt.setString(3, sta.getPassword());
			//pstmt.setString(4, sta.getName());
			//pstmt.setString(5, sta.getSex());
			//pstmt.setString(6, sta.getDepartment());
			//pstmt.setString(7, sta.getLocation());
			
			pstmt1.setString(1, sta.getUsername());
			pstmt1.setString(2, sta.getPassword());
			
			int n = pstmt1.executeUpdate();
			JdbcUtils.relase(null, pstmt1, conn);
			return n;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Staff> findPageListByName(int currentPageIndex,int count,String name) {
		try {
			Connection conn = JdbcUtils.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from staffinfo where name=? order by id limit ?,?");
			ResultSet rs = null;
			
			pstmt.setString(1, name);
			pstmt.setInt(2, count*(currentPageIndex-1));
			pstmt.setInt(3, count);
			
			rs = pstmt.executeQuery();
			
			List<Staff> list = new ArrayList<Staff>();
			
			while(rs.next()){
                Staff sta = new Staff();
				
				sta.setId(rs.getString("id"));
				sta.setName(rs.getString("name"));
				sta.setSex(rs.getString("sex"));
				sta.setDepartment(rs.getString("department"));
				sta.setLocation(rs.getString("location"));
				
				list.add(sta);
				
			}
            JdbcUtils.relase(rs, pstmt, conn);
			
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Staff> findPageListByName2(int currentPageIndex,int count,String name) {
		try {
			Connection conn = JdbcUtils.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from staffinfo where name=? order by id limit ?,?");
			ResultSet rs = null;
			
			pstmt.setString(1, name);
			pstmt.setInt(2, count*(currentPageIndex-1));
			pstmt.setInt(3, count);
			
			rs = pstmt.executeQuery();
			
			List<Staff> list = new ArrayList<Staff>();
			
			while(rs.next()){
                Staff sta = new Staff();
				
				sta.setId(rs.getString("id"));
				sta.setName(rs.getString("name"));
				sta.setBusinessgrade(rs.getString("businessgrade"));
				sta.setBehaviorgrade(rs.getString("behaviorgrade"));
				
				list.add(sta);
				
			}
            JdbcUtils.relase(rs, pstmt, conn);
			
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Staff> findPageListByName3(int currentPageIndex,int count,String name) {
		try {
			Connection conn = JdbcUtils.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from staffinfo where name=? order by id limit ?,?");
			ResultSet rs = null;
			
			pstmt.setString(1, name);
			pstmt.setInt(2, count*(currentPageIndex-1));
			pstmt.setInt(3, count);
			
			rs = pstmt.executeQuery();
			
			List<Staff> list = new ArrayList<Staff>();
			
			while(rs.next()){
                Staff sta = new Staff();
				
				sta.setId(rs.getString("id"));
				sta.setName(rs.getString("name"));
				sta.setSalary(rs.getString("salary"));
				sta.setReward(rs.getString("reward"));
				
				list.add(sta);
				
			}
            JdbcUtils.relase(rs, pstmt, conn);
			
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getTotalNameStaff(String name) {
		try {
			Connection conn = JdbcUtils.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select count(*) from staffinfo where name=?");
			ResultSet rs = null;
			
			pstmt.setString(1, name);
			
			rs = pstmt.executeQuery();
			int n=0;
			
			if(rs.next())
				n= rs.getInt(1);
			JdbcUtils.relase(null, pstmt, conn);
			
			return n;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int updateStaffById(String id,Staff sta) {
		try {
			Connection conn = JdbcUtils.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("update staffinfo set name=?,sex=?,department=?,location=?,businessgrade=?,behaviorgrade=?,salary=?,reward=? where id=?");
						
			pstmt.setString(1, sta.getName());
			pstmt.setString(2, sta.getSex());
			pstmt.setString(3, sta.getDepartment());
			pstmt.setString(4, sta.getLocation());
			pstmt.setString(5, sta.getBusinessgrade());
			pstmt.setString(6, sta.getBehaviorgrade());
			pstmt.setString(7, sta.getSalary());
			pstmt.setString(8, sta.getReward());
			pstmt.setString(9, id);
			
			int n = pstmt.executeUpdate();
			JdbcUtils.relase(null, pstmt, conn);
			return n;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
}
	
	@Override
	public List<Staff> getAllUser() {
		// TODO Auto-generated method stub
		try {
			Connection conn = JdbcUtils.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from staffinfo");
			ResultSet rs = null;
			rs = pstmt.executeQuery();
			
			List<Staff> list = new ArrayList<Staff>();
			
			while(rs.next()){
				Staff staff = new Staff();
				
				staff.setUsername(rs.getString("username"));
				staff.setId(rs.getString("id"));
				staff.setPassword(rs.getString("password"));
				staff.setRole(rs.getString("role"));
				
				list.add(staff);
				}
			JdbcUtils.relase(rs, pstmt, conn);
			return list;
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int updateUserRole(String username, String role) {
		// TODO Auto-generated method stub
		try {
			//���²������������� ��Ҫע��
			Connection conn = JdbcUtils.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("update staffinfo set role=? where username=?");
			pstmt.setString(1, role);
			pstmt.setString(2, username);
			int n = pstmt.executeUpdate();
			
			JdbcUtils.relase(null, pstmt, conn);
			
			return n;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	/*@Override
	public int addUser1(Staff staff) {
		// TODO Auto-generated method stub
		return 0;
	}
*/
	
	public int updateStaffInfoById(String id,Staff sta) {
		try {
			Connection conn = JdbcUtils.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("update staffinfo set name=?,password=?,sex=?,location=? where id=?");
			
			
			pstmt.setString(1, sta.getName());
			pstmt.setString(2, sta.getPassword());
			pstmt.setString(3, sta.getSex());
			pstmt.setString(4, sta.getLocation());
			pstmt.setString(5, id);
			
			int n = pstmt.executeUpdate();
			JdbcUtils.relase(null, pstmt, conn);
			return n;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public int updateRole(String id, String role) {
		// TODO Auto-generated method stub
		try {
			//���²������������� ��Ҫע��
			Connection conn = JdbcUtils.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("update staffinfo set role=? where id=?");
			pstmt.setString(1, role);
			pstmt.setString(2, id);
			int n = pstmt.executeUpdate();
			
			JdbcUtils.relase(null, pstmt, conn);
			
			return n;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
}
