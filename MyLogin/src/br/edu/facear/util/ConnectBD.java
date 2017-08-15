package br.edu.facear.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectBD {
	private Connection con;
	
	private String driver;
	private String url;
	private String username;
	private String password;
	
	public ConnectBD(){
		
		driver = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/MyLogin";
		username = "root";
		password = "";
		
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName(driver);
		this.con=DriverManager.getConnection(url,username,password);
		return this.con;
	}
}
