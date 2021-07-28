package com.amdocs.training.DAO;

import java.util.List;

import com.amdocs.training.model.Course;

public interface CourseDAO {
	List<Course> findAll();
	boolean addCourse(Course course);
	Course getCourseByName(String name);
	boolean delete(int id);
	void update(int id,String resource);
}
