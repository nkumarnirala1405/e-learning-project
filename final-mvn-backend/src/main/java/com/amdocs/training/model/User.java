package com.amdocs.training.model;

public class User {
	int userId;
	String name;
	String email;
	String address;
	String password;
	String date;
	long phone;
	public User(int userId, String name, String email, String address, String password, String date, long phone) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.address = address;
		this.password = password;
		this.date = date;
		this.phone = phone;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", address=" + address + ", password="
				+ password + ", date=" + date + ", phone=" + phone + "]";
	}
	
	
	
	
}
