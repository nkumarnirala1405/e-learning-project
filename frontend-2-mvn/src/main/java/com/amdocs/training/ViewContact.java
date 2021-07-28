package com.amdocs.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.training.DAO.ContactDAO;
import com.amdocs.training.DAOImplementation.ContactDAOImpl;
import com.amdocs.training.model.Contact;

@WebServlet("/viewContact")
public class ViewContact extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		ContactDAO f = new ContactDAOImpl();
		List<Contact> list = f.findAll();

		for (Contact l : list) {
			out.println(l);
		}
	}

}
