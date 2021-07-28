package com.amdocs.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.amdocs.training.Util.DataSourceUtil;

@WebServlet("/userlogin")
public class UserLogin extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//resp.sendRedirect("Course.html");
		PrintWriter out = resp.getWriter();
		
		String name=req.getParameter("name");
		String pass=req.getParameter("password");
		DataSource dataSource = DataSourceUtil.dataSource();
		String querry="select * from user where name="+"'"+name+"' and "+"password="+"'"+pass+"'";
		Connection connection=null;
		try {
			connection = dataSource.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(querry);
			if(rs.next())
			{
				resp.sendRedirect("userindex.html");
			}
			else
			{
				out.println("no record found in database");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//out.println("querry="+querry);

	}

}
