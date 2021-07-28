package com.amdocs.training.eLearning;

import com.amdocs.training.DAO.ContactDAO;
import com.amdocs.training.DAOImplementation.ContactDAOImpl;
import com.amdocs.training.model.Contact;

public class ContactController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContactDAO x = new ContactDAOImpl();
//		int user_id, int contact_id, String name, String email, String message, long phone
		x.addContact(new Contact(3,100,"nitsh","Pariml@gmail.com","yeah bo",19456789L));
//		Contact y = x.getContactByName("kiran");
//		if(y!=null) {
//			System.out.println(y);
//		}else {
//			System.out.println("No such contact with this name!!");
//		}
//		boolean y = x.delete("Parimal");
//		if(y) {
//			System.out.println("Contact deleted Successfully!!");
//		}else {
//			System.out.println("No such contact in the list!!");
//		}
		//x.update("Kiran",89321452L);
		

	}

}
