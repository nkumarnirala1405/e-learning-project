package com.amdocs.training.DAOImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.amdocs.training.DAO.CourseDAO;
import com.amdocs.training.Util.DataSourceUtil;
import com.amdocs.training.model.Course;

public class CourseDAOImpl implements CourseDAO{
	
	DataSource dataSource = DataSourceUtil.dataSource();
	
	
	@Override
	public List<Course> findAll() {
		List<Course> courses = new ArrayList<>();
		String query = "select * from course";
		try {
			Connection connection = dataSource.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String resource = rs.getString("resource");
				int fee = rs.getInt("price");
				String desc = rs.getString("description");
				Course course = new Course(id, name, resource, fee, desc);
				courses.add(course);
			}
			return courses;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addCourse(Course course) {
		String query = "insert into course values(?,?,?,?,?)";
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, course.getCourseId());
			ps.setString(2, course.getCourseName());
			ps.setString(3, course.getCourseResource());
			ps.setInt(4, course.getCourseFee());
			ps.setString(5, course.getCourseDesc());
			ps.executeUpdate();
			//System.out.println(course);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Course getCourseByName(String name) {
		try {
			Connection connection = dataSource.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM course WHERE name="+'"'+name+'"');
			if(rs.next()) {
				
				int id = rs.getInt("id");
				String nam = rs.getString("name");
				String resource = rs.getString("resource");
				int price = rs.getInt("price");
				String description = rs.getString("description");
				
				return new Course(id,nam,resource,price,description);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean delete(int id) {
		
		try {
			Connection connection = dataSource.getConnection();
            Statement stmt = connection.createStatement();
            int executeUpdate = stmt.executeUpdate("DELETE FROM course WHERE id=" + id);
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
	public void update(int id,String resource) {
		// TODO Auto-generated method stub
		String sql = "update course set resource=?  where id = ?";
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(2, id);
			ps.setString(1, resource);
			int executeUpdate = ps.executeUpdate();
			if(executeUpdate > 0) {
				System.out.println("Course updated Successfully");
			}else {
				System.out.println("Try Again!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
