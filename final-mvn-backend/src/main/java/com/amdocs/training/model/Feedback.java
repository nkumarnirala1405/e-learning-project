package com.amdocs.training.model;

public class Feedback {
	int feedbackId;
	String name;
	String email;
	int userId;
	String feedback;
	public Feedback(int feedbackId, String name, String email, int userId, String feedback) {
		super();
		this.feedbackId = feedbackId;
		this.name = name;
		this.email = email;
		this.userId = userId;
		this.feedback = feedback;
	}
	public int getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", name=" + name + ", email=" + email + ", userId=" + userId
				+ ", feedback=" + feedback + "]";
	}
}
