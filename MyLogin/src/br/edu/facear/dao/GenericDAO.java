package br.edu.facear.dao;

import java.sql.Connection;
import java.sql.SQLException;

import br.edu.facear.util.ConnectBD;

public class GenericDAO {
	private ConnectBD db= new ConnectBD();
	protected Connection connect;
	
	public void openConnection() throws ClassNotFoundException, SQLException{
		connect = db.getConnection();
	}
	
	public void closeConnection(){
		if(connect!=null){
			try {
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("ERROR ON CLOSING CONNECTION");
			}
		}
	}
}
