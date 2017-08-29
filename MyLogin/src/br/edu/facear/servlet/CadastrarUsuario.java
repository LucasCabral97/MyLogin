package br.edu.facear.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.facear.model.Cliente;
import br.edu.facear.service.AutenticarUsuarioService;

/**
 * Servlet implementation class CadastrarUsuario
 */
@WebServlet("/CadastrarUsuario")
public class CadastrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String next_page = "/cadastro.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(next_page);
		rd.forward(request, response);
		/*String email=request.getParameter("emailCad");
		String senha=request.getParameter("senhaCad");
		String nome=request.getParameter("nomeCad");
		String cpf=request.getParameter("cpfCad");
		boolean aux=false;
		Cliente cliente=new Cliente(nome, cpf, email, senha);
		
		aux=AutenticarUsuarioService.cadastrar(cliente);
		
		RequestDispatcher rf = getServletContext().getRequestDispatcher(next_page);
		rf.forward(request, response);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
