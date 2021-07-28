package com.amdocs.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.training.DAO.CourseDAO;
import com.amdocs.training.DAOImplementation.CourseDAOImpl;
import com.amdocs.training.model.Course;

@WebServlet("/Course")
public class CourseRegistration extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out= resp.getWriter();
		int courseID= Integer.parseInt(req.getParameter("id"));
		String coursName= req.getParameter("name");
		String courseResource=req.getParameter("resource");
		int courseFee=Integer.parseInt(req.getParameter("price"));
		String courseDesc=req.getParameter("desc");
		
		CourseDAO x = new CourseDAOImpl();
		
		Course course= new Course(courseID,coursName,courseResource,courseFee,courseDesc);
		
		
		if(x.addCourse(course))
		{
		  out.println("course added succefully");	
		}
		else
		{
			  out.println("course adding Failed");	

		}
		
		
	}
	
	

}
