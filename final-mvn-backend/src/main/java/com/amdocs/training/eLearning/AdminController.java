package com.amdocs.training.eLearning;

import java.util.List;

import com.amdocs.training.DAO.AdminDAO;
import com.amdocs.training.DAOImplementation.AdminDAOImpl;
import com.amdocs.training.model.Admin;

public class AdminController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdminDAO x = new AdminDAOImpl();
	x.addAdmin(new Admin(2,"Kiran","kiran@123","kiran@gmail.com"));
//		x.update(1,"parimal");
//		List<Admin> list = x.findAll();
//		for(Admin l : list) {
//			System.out.println(l);
		//}
		
	}

}
