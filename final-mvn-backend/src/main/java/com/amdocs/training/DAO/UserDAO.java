package com.amdocs.training.DAO;

import java.util.List;

import com.amdocs.training.model.User;

public interface UserDAO {
	List<User> findAll();
	boolean addUser(User user);
	User getUserById(int id);
	boolean delete(int id);
	void update(int id,String password);
	
}
