package br.edu.facear.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.facear.model.Cliente;
import br.edu.facear.service.ClienteService;

/**
 * Servlet implementation class ObterClienteServlet
 */
@WebServlet("/ObterClienteServlet")
public class ObterClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObterClienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//Passo 1 - obter parametro id pela url
		String id=request.getParameter("id");
		String nestPage="/listarUsuarios.jsp";
		//passo 2 - converter id para integer
		if(id!=null){
			Integer x = new  Integer(Integer.parseInt(id));
			
			//passo 3 - inserir lógica para chamar service
			ClienteService service=new ClienteService();
			Cliente c;
			try {
				c = service.obterClientePorId(x);
				request.setAttribute("cliente", c);
				if(c!=null){
					nestPage="/detalhesCliente.jsp";
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		//passo 4 - Rediecionar para detalhesCliente.jsp
		RequestDispatcher rs= getServletContext().getRequestDispatcher(nestPage);
		rs.forward(request, response);
	}
	

}
