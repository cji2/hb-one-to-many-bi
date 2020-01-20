package edu.gmu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnect {

	public static void main(String[] args) {

		String jdbcUrl = 
			"jdbc:mysql://localhost:3306/hb-one-to-many?useSSL=false&serverTimezone=UTC";
		String user = "gmstudent";
		String pass = "gmstudent";
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection successful!!!");
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
