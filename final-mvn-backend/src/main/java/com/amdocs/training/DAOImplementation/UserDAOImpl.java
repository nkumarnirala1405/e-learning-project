package com.amdocs.training.DAOImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.amdocs.training.DAO.UserDAO;
import com.amdocs.training.Util.DataSourceUtil;
import com.amdocs.training.model.User;

public class UserDAOImpl implements UserDAO{

	//Connection connection = DBUtil.getConnection();
	DataSource dataSource = DataSourceUtil.dataSource();
	//Connection connection = dataSource.getConnection();
	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<>();
		String query = "select * from user";
		try {
			Connection connection = dataSource.getConnection();
			
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String password = rs.getString("password");
				String date = rs.getString("reg_date");
				long phone = rs.getLong("phone");
				User user = new User(id, name, email, address, password, date, phone);
				users.add(user);
			}
			return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addUser(User user) {
		
		String query = "insert into user values(?,?,?,?,?,?,?)";
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, user.getUserId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getAddress());
			ps.setString(5, user.getPassword());
			ps.setString(6, user.getDate());
			ps.setLong(7, user.getPhone());
			ps.executeUpdate();
			//System.out.println(user);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User getUserById(int id) {
		try {
			Connection connection = dataSource.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE id=" + id);

            if(rs.next())
            {
                int userId =  rs.getInt("id") ;
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String password = rs.getString("password");
                String date = rs.getString("reg_date");
                long phone = rs.getLong("phone");
                User user = new User(userId,name,email,address,password,date,phone);
                return user;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
		
		return null;
	}

	@Override
	public boolean delete(int id) {
		try {
			Connection connection = dataSource.getConnection();
            Statement stmt = connection.createStatement();
            int executeUpdate = stmt.executeUpdate("DELETE FROM user WHERE id=" + id);
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
		String sql = "update user set password=?  where id = ?";
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(2, id);
			ps.setString(1, password);
			int executeUpdate = ps.executeUpdate();
			if(executeUpdate > 0) {
				System.out.println("Employee updated Successfully");
			}else {
				System.out.println("Try Again!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
