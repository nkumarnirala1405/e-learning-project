package com.amdocs.training.model;

public class Contact {
	int userId;
	int contactId;
	String name;
	String email;
	String message;
	long phone;
	
	public Contact(int user_id, int contact_id, String name, String email, String message, long phone) {
		super();
		this.userId = user_id;
		this.contactId = contact_id;
		this.name = name;
		this.email = email;
		this.message = message;
		this.phone = phone;
	}
	public int getUser_id() {
		return userId;
	}
	public void setUser_id(int user_id) {
		this.userId = user_id;
	}
	public int getContact_id() {
		return contactId;
	}
	public void setContact_id(int contact_id) {
		this.contactId = contact_id;
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Contact [user_id=" + userId + ", contact_id=" + contactId + ", name=" + name + ", email=" + email
				+ ", message=" + message + ", phone=" + phone + "]";
	}
	
}
