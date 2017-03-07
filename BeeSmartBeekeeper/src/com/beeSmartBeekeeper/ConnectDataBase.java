package com.beeSmartBeekeeper;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectDataBase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}
		Connection connection = null;

		try {
			connection = DriverManager
			.getConnection("jdbc:mysql://localhost:3306/beesmartbeekeeper?autoReconnect=true&useSSL=false","root", "123456");

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}

		if (connection != null) {
		} else {
			System.out.println("Failed to make connection!");
		}
	  }
	}

	


