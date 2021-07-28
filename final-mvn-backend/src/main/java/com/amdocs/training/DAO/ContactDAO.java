package com.amdocs.training.DAO;

import java.util.List;

import com.amdocs.training.model.Contact;

public interface ContactDAO {
	List<Contact> findAll();
	boolean addContact(Contact contact);
	Contact getContactByName(String name);
	boolean delete(String name);
	void update(String name,long phone);
}
