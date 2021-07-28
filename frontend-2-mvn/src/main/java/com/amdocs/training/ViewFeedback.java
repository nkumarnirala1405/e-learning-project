package com.amdocs.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.training.DAO.FeedbackDAO;
import com.amdocs.training.DAOImplementation.FeedbackDAOImpl;
import com.amdocs.training.model.Feedback;
import com.amdocs.training.model.User;

@WebServlet("/viewFeedback")
public class ViewFeedback extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		FeedbackDAO f = new FeedbackDAOImpl();
		List<Feedback> list = f.findAll();

		for (Feedback l : list) {
			out.println(l);
		}
	}

}
