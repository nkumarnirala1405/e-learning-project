package com.amdocs.training.DAOImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.amdocs.training.DAO.AdminDAO;
import com.amdocs.training.Util.DataSourceUtil;
import com.amdocs.training.model.Admin;

public class AdminDAOImpl implements AdminDAO{
	//Connection connection = DBUtil.getConnection();
	DataSource dataSource = DataSourceUtil.dataSource();

	
	
	public List<Admin> findAll() {
		List<Admin> admins = new ArrayList<Admin>();
		String query = "select * from admin";
		try {
			Connection connection = dataSource.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String password = rs.getString("password");
				String email = rs.getString("email");
				Admin admin = new Admin(id,name,password,email);
				admins.add(admin);
			}
			return admins;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addAdmin(Admin admin) {
		String query = "insert into admin values(?,?,?,?)";
		try {
			Connection connection = dataSource.getConnection();

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, admin.getAdminId());
			ps.setString(2, admin.getName());
			ps.setString(3, admin.getPassword());
			ps.setString(4, admin.getEmail());
			
			ps.executeUpdate();
			//System.out.println(admin);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Admin getAdminById(int id) {
		// TODO Auto-generated method stub
		try {
			Connection connection = dataSource.getConnection();

			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM admin WHERE id="+id);
			if(rs.next()){
				int userId = rs.getInt("id");
				String name = rs.getString("name");
				String password = rs.getString("password");
				String email = rs.getString("email");
				return new Admin(userId,name,password,email);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		try {
			Connection connection = dataSource.getConnection();

            Statement stmt = connection.createStatement();
            int executeUpdate = stmt.executeUpdate("DELETE FROM admin WHERE id=" + id);
            if(executeUpdate > 0) {
            	System.out.println("Deleted Succesfully!!");
            }else {
            	System.out.println("Try Again!!");
            }
            

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
		
		return false;
	}

	@Override
	public void update(int id,String password) {
		// TODO Auto-generated method stub
		String sql = "update admin set password=?  where id = ?";
		try {
			Connection connection = dataSource.getConnection();

			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(2, id);
			ps.setString(1, password);
			int executeUpdate = ps.executeUpdate();
			if(executeUpdate > 0) {
				System.out.println("Admin updated Successfully");
			}else {
				System.out.println("Try Again!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
