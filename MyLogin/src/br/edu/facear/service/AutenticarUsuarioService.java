package br.edu.facear.service;

import java.sql.SQLException;

import br.edu.facear.dao.ClienteDAO;
import br.edu.facear.model.Cliente;

public class AutenticarUsuarioService {
	public static Cliente autenticar(String email, String senha){
		ClienteDAO dao=new ClienteDAO();
		Cliente c=null;
		try {
			c = dao.autenticar(email, senha);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	public static boolean cadastrar(Cliente c){
		ClienteDAO dao=new ClienteDAO();
		boolean aux=false;
		try {
			aux=dao.cadastrar(c);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return aux;
	}
}
