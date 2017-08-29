package br.edu.facear.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.edu.facear.model.Cliente;

public class ClienteDAO extends GenericDAO{
	private PreparedStatement ps;
	private ResultSet rs;
	private String LOGIN_SQL="SELECT * FROM TBCLIENTE WHERE "
						   + "EMAIL= ? AND SENHA= ?;";
	private String LOGIN_ID="SELECT * FROM TBCLIENTE ;";
	private String INSERT_SQL="INSERT INTO TBCLIENTE (nome,cpf,email,senha) VALUES (?,?,?,?);";
	private String LISTA_SQL="SELECT * FROM TBCLIENTE;";
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
		System.out.println("dsfasfdafas");
		System.out.println(cliente.getCpf()+cliente.getEmail()+cliente.getNome()+cliente.getSenha());
		PreparedStatement stmt=null;
		openConnection();
		stmt=connect.prepareStatement(INSERT_SQL);
		stmt.setString(1, cliente.getNome());
		stmt.setString(2, cliente.getCpf());
		stmt.setString(3, cliente.getEmail());
		stmt.setString(4, cliente.getSenha());
		if(stmt.executeUpdate()>0){
			cadastrou=true;
		}
		closeConnection();
		return cadastrou;
	}
	public ArrayList<Cliente> listar() throws ClassNotFoundException, SQLException{
		ArrayList<Cliente> listaCliente =new ArrayList<Cliente>();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		openConnection();
		stmt=connect.prepareStatement(LISTA_SQL);
		rs=stmt.executeQuery();
		
		while(rs.next()){
			Cliente c=new Cliente(rs.getInt("id"),rs.getString("nome"),rs.getString("cpf"), rs.getString("email"), rs.getString("senha"));
			listaCliente.add(c);
		}
		closeConnection();
		
		
		return listaCliente;
	}
	public Cliente obterClientePorId(Integer id) throws ClassNotFoundException, SQLException{
		openConnection();
		Cliente c=null;
		
		ps =connect.prepareStatement(LOGIN_ID);
		ResultSet rs = ps.executeQuery();
		if(rs != null){
			while(rs.next()){
				c=new Cliente(rs.getInt("id"),rs.getString("nome"),rs.getString("cpf"), rs.getString("email"), rs.getString("senha"));
				
			}
		}
		closeConnection();
		return c;
	}
}
