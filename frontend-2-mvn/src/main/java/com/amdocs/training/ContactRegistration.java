 package com.amdocs.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.training.DAOImplementation.ContactDAOImpl;
import com.amdocs.training.model.Contact;

@WebServlet("/Contact")
public class ContactRegistration extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out=resp.getWriter();
		
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String msg =req.getParameter("message");
		long phone =Long.parseLong(req.getParameter("phone")); 
		int id =Integer.parseInt(req.getParameter("id"));
		int u_id =Integer.parseInt(req.getParameter("u_id"));
		
		Contact contact= new Contact(u_id,id,name,email,msg,phone);
		ContactDAOImpl dao= new ContactDAOImpl();
		
		
		//out.println(contact.toString());
		
		if(dao.addContact(contact))
		{
			out.println("contact added Succefully");
		}
		else
		{
			out.println("contact adding Failed");
			
	
		}

	}

}
