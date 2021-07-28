package com.amdocs.training.DAOImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.amdocs.training.DAO.FeedbackDAO;
import com.amdocs.training.Util.DataSourceUtil;
import com.amdocs.training.model.Feedback;

public class FeedbackDAOImpl implements FeedbackDAO{
	//Connection connection = DBUtil.getConnection();
	DataSource dataSource = DataSourceUtil.dataSource();
	@Override
	public List<Feedback> findAll() {
		List<Feedback> feedbacks = new ArrayList<>();
		String query = "select * from feedback";
		try {
			Connection connection=dataSource.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				int userId = rs.getInt("userId");
				String fback = rs.getString("review");
				Feedback feedback = new Feedback(id, name, email, userId, fback);
				feedbacks.add(feedback);
			}
			return feedbacks;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addFeedback(Feedback feedback) {
		String query = "insert into feedback values(?,?,?,?,?)";
		try {
			Connection connection=dataSource.getConnection();

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, feedback.getFeedbackId());
			ps.setString(3, feedback.getName());
			ps.setString(4, feedback.getEmail());
			ps.setInt(2, feedback.getUserId());
			ps.setString(5, feedback.getFeedback());
			
			ps.executeUpdate();
			//System.out.println(feedback);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Feedback getFeedbackById(int id) {
		try {
			Connection connection=dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		try {
			Connection connection=dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public void update(int id) {
		try {
			Connection connection=dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		
	}

}
