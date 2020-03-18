package com.ttlecom.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	private final String url = "jdbc:mysql://localhost:3306/crm";
	private final String user = "root";
	private final String password = "123456";
	private static JDBCConnection _instance = null;

	private JDBCConnection() {
	}

	public static JDBCConnection getInstance() {
		if (_instance == null) {
			_instance = new JDBCConnection();
			return _instance;
		}
		return _instance;
	}

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("Không tìm thấy driver!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Không tìm thấy database!");
			e.printStackTrace();
		}
		return null;
	}

//	private static final String url = "jdbc:mysql://localhost:3306/crm";
//	private static final String user = "root";
//	private static final String password = "123456";
//
//
//	public static Connection getConnection() {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			return DriverManager.getConnection(url, user, password);
//		} catch (ClassNotFoundException e) {
//			System.out.println("Không tìm thấy driver!");
//			e.printStackTrace();
//		} catch (SQLException e) {
//			System.out.println("Không tìm thấy database!");
//			e.printStackTrace();
//		}
//		return null;
//	}


}
