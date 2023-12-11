package database;

import java.sql.*;

public class ConnectToDatabase {
	
	private static final String url = "jdbc:sqlserver://";
	private static final String serverName = "MSI\\MSSQLSERVER2022";
	private static final String portNumber = "1433";
	private static final String databaseName = "Dorm";
	private static final String user = "sa";
	private static final String password = "123456";
	
	public static String getConnectionUrl() {
		return url + serverName + ":" + portNumber 
				+ "; databaseName=" + databaseName
				+ "; user=" + user + "; password=" + password ;
	}
	
	public static Connection getConnect() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(getConnectionUrl());
		} catch (Exception e) {
			con = null;
			e.printStackTrace();
		}
		return con;
	}
}
