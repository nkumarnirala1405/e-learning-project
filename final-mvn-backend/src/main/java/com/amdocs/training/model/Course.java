package com.amdocs.training.model;

public class Course {
	int courseId;
	String courseName;
	String courseResource;
	int courseFee;
	String courseDesc;
	public Course(int courseId, String coursName, String courseResource, int courseFee, String courseDesc) {
		super();
		this.courseId = courseId;
		this.courseName = coursName;
		this.courseResource = courseResource;
		this.courseFee = courseFee;
		this.courseDesc = courseDesc;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String coursName) {
		this.courseName = coursName;
	}
	public String getCourseResource() {
		return courseResource;
	}
	public void setCourseResource(String courseResource) {
		this.courseResource = courseResource;
	}
	public int getCourseFee() {
		return courseFee;
	}
	public void setCourseFee(int courseFee) {
		this.courseFee = courseFee;
	}
	public String getCourseDesc() {
		return courseDesc;
	}
	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", coursName=" + courseName + ", courseResource=" + courseResource
				+ ", courseFee=" + courseFee + ", courseDesc=" + courseDesc + "]";
	}
	
	
	
}
