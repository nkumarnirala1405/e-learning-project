package com.amdocs.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.training.DAOImplementation.AdminDAOImpl;
import com.amdocs.training.model.Admin;

@WebServlet("/adminregistration")
public class AdminRegistration extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();

		String name = req.getParameter("name");
		int id = Integer.parseInt(req.getParameter("id"));
		String email = req.getParameter("email");
		String pass = req.getParameter("password");

		Admin admin = new Admin(id, name, pass, email);

		AdminDAOImpl x = new AdminDAOImpl();
		if (x.addAdmin(admin)) {
			out.println("Admin added into database");
		} else {
			out.println("failed");

		}
	}

}
