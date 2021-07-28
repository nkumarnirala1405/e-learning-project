package com.amdocs.training.eLearning;

import java.util.List;

import com.amdocs.training.DAO.CourseDAO;
import com.amdocs.training.DAOImplementation.CourseDAOImpl;
import com.amdocs.training.model.Course;

public class CourseController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CourseDAO x = new CourseDAOImpl();
//		int courseId;
//		String coursName;
//		String courseResource;
//		int courseFee;
//		String courseDesc;
	if(x.addCourse(new Course(1075,"C++ with nitish","C/users/nitish/videos/",5080,"Basic to Advance C++ and Data Structures")))
			{
			System.out.println("course added");
			}
		else
		{
			System.out.println("course adding failed");
		}
//		List<Course> list = x.findAll();
//		for(Course l : list) {
//			System.out.println(l);
//		}
//		Course y = x.getCourseByName("C++ with Parimal");
//		System.out.println(y);
//		x.update(1,"c/users/video/");
//		x.delete(1);
//		List<Course> list = x.findAll();
//		for(Course l : list) {
//			System.out.println(l);
//		}
	}

}
