package com.amdocs.training.eLearning;

import com.amdocs.training.DAO.FeedbackDAO;
import com.amdocs.training.DAOImplementation.FeedbackDAOImpl;
import com.amdocs.training.model.Feedback;


public class UserController {

	public static void main(String[] args) {
		
		Feedback f= new Feedback(303,"nitish","abc@gmail.com",100,"hello bhai");
		FeedbackDAO x= new FeedbackDAOImpl();
		x.addFeedback(f);
		
		// TODO Auto-generated method stub
		
		
//		UserDAO x = ImplDAO.getInstance();
//		boolean check = x.addUser(new User(
//				1042,
//				"alia",
//				"nk@gmail.com",
//				"Noida",
//				"rajat",
//				"01-01-2020",
//				1096590234L
//				));
//		if(check) {
//			System.out.println("User Added Successfully!!");
//		}
//		else
//		{
//			System.out.println("failed adding");
//
//		}
		//x.display();
		
		
		
//		User user = x.getUserById(1);
//		System.out.println(user);
		
//		x.update(1, "parimal@123");
//		List<User> list = new ArrayList<>();
//		list = x.findAll();
//		for(User l : list) {
//			System.out.println(l);
//		}
//		
		
		
	}

}
