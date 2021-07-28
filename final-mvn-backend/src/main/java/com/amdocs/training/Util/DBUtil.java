package com.amdocs.training.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static Connection connection = null;
	private DBUtil() {
	}
	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/eLearning";
		String user = "root";
		String password = "asdfghjkl";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			if(connection == null) {
				connection = DriverManager.getConnection(url,user,password);
			}
			System.out.println("Database connected");
			return connection;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
