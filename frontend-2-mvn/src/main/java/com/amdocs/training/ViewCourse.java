package com.amdocs.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.training.DAO.CourseDAO;
import com.amdocs.training.DAOImplementation.CourseDAOImpl;
import com.amdocs.training.model.Course;
import com.amdocs.training.model.Feedback;

@WebServlet("/viewCourse")
public class ViewCourse extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();

		CourseDAO f = new CourseDAOImpl();
		List<Course> list = f.findAll();

		for (Course l : list) {
			out.println(l);
		}
	}

}
