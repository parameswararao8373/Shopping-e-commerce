package com.shopping.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	
	public static  Connection forMQLConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
	 return DriverManager.getConnection("jdbc:mysql://localhost:3306/a14_e_commerce?user=root&password=root");
	}
}
