package edu.up.br.exemplo.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("user", null );
		redirecionar( "login.jsp", request, response);		
	}
	
	private void redirecionar(String paginaDestino, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher( "/"+paginaDestino );
		dispatcher.forward( request, response );
	}
}
