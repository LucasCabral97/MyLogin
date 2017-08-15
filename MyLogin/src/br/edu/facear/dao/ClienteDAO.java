package br.edu.facear.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.facear.model.Cliente;

public class ClienteDAO extends GenericDAO{
	private PreparedStatement ps;
	private ResultSet rs;
	private String LOGIN_SQL="SELECT * FROM TBCLIENTE WHERE "
						   + "EMAIL= ? AND SENHA= ?;";
	private String INSERT_SQL="INSERT INTO TBCLIENTE (nome,cpf,email,senha) VALUES (?,?,?,?	),"+" "+"Statement.RETURN_GENERATED_KEYS ";
	public Cliente autenticar(String email,String senha) throws ClassNotFoundException, SQLException{
		System.out.println(email + senha);
		openConnection();
		Cliente c=null;
		
		ps =connect.prepareStatement(LOGIN_SQL);
		ps.setString(1, email);
		ps.setString(2, senha);
		ResultSet rs = ps.executeQuery();
		if(rs != null){
			while(rs.next()){
				c=new Cliente(rs.getInt("id"),rs.getString("nome"),rs.getString("cpf"), rs.getString("email"), rs.getString("senha"));
				
			}
		}
		closeConnection();
		return c;
	}
	public boolean cadastrar(Cliente cliente) throws ClassNotFoundException, SQLException{
		boolean cadastrou=false;
		PreparedStatement stmt=null;
		openConnection();
		stmt=connect.prepareStatement(INSERT_SQL);
		stmt.setString(1, cliente.getNome());
		stmt.setString(2, cliente.getCpf());
		stmt.setString(1, cliente.getEmail());
		stmt.setString(1, cliente.getSenha());
		if(stmt.executeUpdate()>0){
			cadastrou=true;
		}
		closeConnection();
		return cadastrou;
	}
	
}
