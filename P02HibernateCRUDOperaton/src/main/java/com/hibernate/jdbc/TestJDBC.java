package com.hibernate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
	
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String password = "hbstudent-1T";
		try {
			System.out.println("Connecting to database "+url);
			//load and register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			//Open a connection to the database.
			Connection conn = DriverManager.getConnection(url,user,password);
			System.out.println("Connected Sucessfully!!!!");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
