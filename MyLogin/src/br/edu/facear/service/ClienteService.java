package br.edu.facear.service;

import java.sql.SQLException;

import br.edu.facear.dao.ClienteDAO;
import br.edu.facear.model.Cliente;

public class ClienteService {
	public Cliente obterClientePorId(Integer id) throws ClassNotFoundException, SQLException{
		ClienteDAO dao=new ClienteDAO();
		Cliente c =	dao.obterClientePorId(id);
		return c;
	}

}
