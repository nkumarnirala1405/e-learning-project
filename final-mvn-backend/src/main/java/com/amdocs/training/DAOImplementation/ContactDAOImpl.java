package com.amdocs.training.DAOImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.amdocs.training.DAO.ContactDAO;
import com.amdocs.training.Util.DataSourceUtil;
import com.amdocs.training.model.Contact;

public class ContactDAOImpl implements ContactDAO {
	// Connection connection = DBUtil.getConnection();
	DataSource dataSource = DataSourceUtil.dataSource();

	@Override
	public List<Contact> findAll() {
		List<Contact> contacts = new ArrayList<>();
		String query = "select * from contact";
		try {
			Connection connection = dataSource.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt("userId");
				int contactId = rs.getInt("contactId");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String message = rs.getString("message");
				long phone = rs.getLong("phone");
				Contact contact = new Contact(id, contactId, name, email, message, phone);
				contacts.add(contact);
			}
			return contacts;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addContact(Contact contact) {
		String query = "insert into contact values(?,?,?,?,?,?)";
		try {
			Connection connection = dataSource.getConnection();

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, contact.getContact_id());
			ps.setInt(2, contact.getUser_id());
			ps.setString(3, contact.getName());
			ps.setString(4, contact.getEmail());
			ps.setString(5, contact.getMessage());
			ps.setLong(6, contact.getPhone());
			ps.executeUpdate();
			//System.out.println(contact);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Contact getContactByName(String name) {
		// TODO Auto-generated method stub
		try {
			Connection connection = dataSource.getConnection();

			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM contact WHERE name=" + '"' + name + '"');
			if (rs.next()) {
				int contactId = rs.getInt("contactId");
				int userId = rs.getInt("userId");
				String nam = rs.getString("name");
				String email = rs.getString("email");
				String message = rs.getString("message");
				long phone = rs.getLong("phone");
				return new Contact(contactId, userId, nam, email, message, phone);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean delete(String name) {
		// TODO Auto-generated method stub
		try {
			Connection connection = dataSource.getConnection();

			Statement stmt = connection.createStatement();
			int deleted = stmt.executeUpdate("DELETE FROM contact where name=" + '"' + name + '"');
			if (deleted > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public void update(String name, long phone) {
		// TODO Auto-generated method stub
		String sql = "update contact set phone=?  where name =" + '"' + name + '"';
		try {
			Connection connection = dataSource.getConnection();

			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setLong(1, phone);
			int executeUpdate = ps.executeUpdate();
			if (executeUpdate > 0) {
				System.out.println("Contact updated Successfully");
			} else {
				System.out.println("Try Again!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
