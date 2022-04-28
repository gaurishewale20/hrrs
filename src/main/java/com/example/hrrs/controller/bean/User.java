package com.example.hrrs.controller.bean;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	private String userId;
	private Long id;
	private String password;
	private String name;
	private BigDecimal phone;
	private String email;
	private String gender;
	private Long roleId;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}	
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id)
	{
		this.id = id;
	}
	public Long getRoleId() {
		return roleId;
	}	
	
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
	// NAme,phone,email,gender
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	public BigDecimal getPhone() {
		return phone;
	}
	
	public void setPhone(BigDecimal phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "User {userId=" + userId + ", password= "+ password+ "}"; 
	}
	
}

