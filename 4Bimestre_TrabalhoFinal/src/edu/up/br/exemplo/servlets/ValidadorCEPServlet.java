package edu.up.br.exemplo.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.up.br.exemplo.model.Endereco;

/**
 * Servlet implementation class ValidadorCEPServlet
 */
@WebServlet("/ValidadorCEP")
public class ValidadorCEPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String cep = request.getParameter("campoCEP");
		
		Endereco xuxu 		= new Endereco();
		String resultado 	= xuxu.buscar( cep );
		
		if( resultado != null ) {
			request.setAttribute( "chaveEndereco", resultado );			
			redirecionar( "CadastroCliente.jsp", request, response);	
		} else {
			request.setAttribute( "msgErro", "Endereço não encontrado!" );
			request.setAttribute( "corMsgErro", "#0000FF" );
			redirecionar( "Erro.jsp", request, response);
		}
	}
	
	private void redirecionar(String paginaDestino, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher( "/"+paginaDestino );
		dispatcher.forward( request, response );
	}
}