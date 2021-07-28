package com.amdocs.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.training.DAO.ImplDAO;
import com.amdocs.training.DAO.UserDAO;
import com.amdocs.training.model.User;

@WebServlet("/Register")
public class Registration extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();

		String name = req.getParameter("name");
		int id = Integer.parseInt(req.getParameter("id"));
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		String reg_date = req.getParameter("reg_date");
		long phone = Long.parseLong(req.getParameter("phone"));
		String address = req.getParameter("address");

		User user = new User(id, name, email, address, pass, reg_date, phone);

		UserDAO x = ImplDAO.getInstance();

		if (x.addUser(user)) {
			out.println("Added Succefully ");
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.sendRedirect("userAddConfirmation.html");
		} else {
			out.println("failed");
			
		}
		

	}
}
