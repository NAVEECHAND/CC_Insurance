package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
		 private String usernameDb="root";
		 private String passwordDb="";
		 private String urlDb= "jdbc:mysql://localhost:3306/insurance";
		 private String driverName="com.mysql.jdbc.Driver";
		 private static Connection conn;

	
		 public static Connection getdbConnect() {
			    String usernameDb="root";
				String passwordDb="";
				String urlDb="jdbc:mysql://localhost:3306/insurance";
				String driverName="com.mysql.jdbc.Driver";
		 try {
		 Class.forName(driverName);
		 System.out.println("Driver loaded successfully");
		 } catch (ClassNotFoundException e) {
		 System.out.println("Driver not loaded successfully");
		 e.printStackTrace();
		 }

		 try {
		 conn=DriverManager.getConnection(urlDb, usernameDb, passwordDb);
		 System.out.println("connection established successfully");
		 } catch (SQLException e) {
		 System.out.println("connection  not established successfully");
		 e.printStackTrace();
		 }
		 return conn;
		 }
		 public static void dbClose()
		 {
		 try {
		 conn.close();
		 System.out.println("connection closed");
		 } catch (SQLException e) {
		 e.printStackTrace();
		 }
		 }

	}

