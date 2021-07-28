package com.amdocs.training.DAO;

import com.amdocs.training.DAOImplementation.UserDAOImpl;

public class ImplDAO {
	public static UserDAOImpl getInstance() {
		return new UserDAOImpl();
	}
}
