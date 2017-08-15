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
 * Servlet implementation class ValidarUsuario
 */
@WebServlet("/ValidarUsuario")
public class ValidarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("não importa a feira é dia de doideira e não de trablha");
		String next_page = "/index.html";
		String email=request.getParameter("email");
		String senha=request.getParameter("senha");
		//obter do Banco de Dados
		Cliente c =	AutenticarUsuarioService.autenticar( email,senha );
		//colocar na area de memoria da sessao
		
		//pegar getParameter * colocar setAttribute
		
		request.setAttribute("cliente", c);
		
		
		if(c!=null){
			next_page = "/principal.jsp";
		}else{
			next_page = "/cadastro.html";
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(next_page);
		rd.forward(request, response);
	}

}
