package edu.up.br.exemplo.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.up.br.exemplo.model.Cliente;
import edu.up.br.exemplo.model.ClienteBean;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String nickname = request.getParameter("campoUser");
		String password = request.getParameter("campoPassword");
		
		if( nickname != null && password != null) 
		{
			Cliente cliente = new Cliente();
			ClienteBean bean = cliente.autenticar( nickname, password );
			if( bean != null )
			{
				//Criando uma sessão
				HttpSession session = request.getSession();
				//Incluindo o usuario na sessão
				session.setAttribute("user", bean);			
				redirecionar("boasvindas.jsp", request, response);
			} else {
				request.setAttribute("msgErro", "Usuário ou senha inválidos!!");
				request.setAttribute("paginaRetorno", "login.jsp");
				redirecionar("Erro.jsp", request, response);	
			}
			
		}
	}
	
	private void redirecionar(String paginaDestino, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher( "/"+paginaDestino );
		dispatcher.forward( request, response );
	}	
}

