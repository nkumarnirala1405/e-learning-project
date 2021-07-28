package com.amdocs.training.Util;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;


public class DataSourceUtil {
	public static DataSource dataSource() {
		try {
			BasicDataSource ds = new BasicDataSource();
			ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
			ds.setUrl("jdbc:mysql://localhost:3306/eLearning");
			ds.setUsername("root");
			ds.setPassword("asdfghjkl");
			return ds;
		} catch (Exception ex) {
			return null;
		}
	}
}