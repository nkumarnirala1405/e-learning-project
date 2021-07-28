package com.amdocs.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.training.DAOImplementation.UserDAOImpl;
import com.amdocs.training.model.User;

@WebServlet("/viewUser")
public class ViewUser extends HttpServlet {
	
	@Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();	
		UserDAOImpl x= new UserDAOImpl();
		
		
		
		List<User> users=x.findAll();
		for(User l : users) {
			out.println(l);
		}
		
		
	}
	
	
   
	
	

}
