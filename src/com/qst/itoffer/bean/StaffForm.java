package com.qst.itoffer.bean;

import java.io.Serializable;

public class StaffForm implements Serializable{
	
    private String id;
    
    private String username;
    
    private String password;
    
    private String name;
    
    private String sex;
    
    private String department;
    
    private String location;
    
    private String businessgrade;
    
    private String behaviorgrade;
    
    private String salary;
    
    private String reward;
    
	

	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getSalary() {
		return salary;
	}



	public void setSalary(String salary) {
		this.salary = salary;
	}



	public String getReward() {
		return reward;
	}



	public void setReward(String reward) {
		this.reward = reward;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSex() {
		return sex;
	}



	public void setSex(String sex) {
		this.sex = sex;
	}



	public String getDepartment() {
		return department;
	}



	public void setDepartment(String department) {
		this.department = department;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public String getBusinessgrade() {
		return businessgrade;
	}



	public void setBusinessgrade(String businessgrade) {
		this.businessgrade = businessgrade;
	}



	public String getBehaviorgrade() {
		return behaviorgrade;
	}



	public void setBehaviorgrade(String behaviorgrade) {
		this.behaviorgrade = behaviorgrade;
	}



	@Override
	public String toString() {
		return "Staff [id=" + id + ", name=" + name + ", sex=" + sex + ", department=" + department + ", location=" + location
				+ ", businessgrade=" + businessgrade + ", behaviorgrade=" + behaviorgrade + "]";
	}
    
    
    
}
