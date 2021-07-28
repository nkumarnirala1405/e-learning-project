package com.amdocs.training.DAO;

import java.util.List;

import com.amdocs.training.model.Admin;

public interface AdminDAO {
	List<Admin> findAll();
	boolean addAdmin(Admin admin);
	Admin getAdminById(int id);
	boolean delete(int id);
	void update(int id,String password);
}
