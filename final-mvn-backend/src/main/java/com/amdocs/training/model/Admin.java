package com.amdocs.training.model;

public class Admin {
	int adminId;
	String name;
	String password;
	String email;
	public Admin(int adminId, String name, String password, String email) {
		super();
		this.adminId = adminId;
		this.name = name;
		this.password = password;
		this.email = email;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", name=" + name + ", password=" + password + ", email=" + email + "]";
	}
	
	
}
