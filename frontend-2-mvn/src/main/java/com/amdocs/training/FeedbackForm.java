package com.amdocs.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.training.DAOImplementation.FeedbackDAOImpl;
import com.amdocs.training.model.Feedback;

@WebServlet("/feedback")
public class FeedbackForm extends HttpServlet {
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();

		String name = req.getParameter("name");
		int u_id = Integer.parseInt(req.getParameter("u_id"));
		int id = Integer.parseInt(req.getParameter("id"));
		String email = req.getParameter("email");
		String msg = req.getParameter("review");
		
		Feedback f= new Feedback(id, name, email, u_id, msg );
		
		FeedbackDAOImpl x= new FeedbackDAOImpl();
		
		if(x.addFeedback(f))
		{
			out.println("Feedback submited");
		}
		else
		{
			out.println("Feedback submision unsuccessful");

		}
		
	}

}
