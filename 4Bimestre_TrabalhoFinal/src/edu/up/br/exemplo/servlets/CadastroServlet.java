package edu.up.br.exemplo.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.up.br.exemplo.model.Cliente;
import edu.up.br.exemplo.model.ClienteBean;
/**
 * Servlet implementation class CadastroServlet
 */
@WebServlet("/CadastroServlet")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String action = request.getParameter("acao");
		if(action.equals("Gravar"))
		{
			String nome = request.getParameter("campoNome");
			String cpf = request.getParameter("campoCPF");
			String endereco = request.getParameter("campoEndereco");
			String nickname = request.getParameter("campoNickname");
			String password = request.getParameter("campoPassword");
			String admin = request.getParameter("campoAdmin");
			
			ClienteBean bean = new ClienteBean();
			bean.setNome(nome);
			bean.setCpf(cpf);
			bean.setEndereco(endereco);
			bean.setNickname(nickname);
			bean.setPassword(password);
			if( admin != null && admin.equals("1") ) {
				bean.setAdmin(true);
			}
			Cliente cliente = new Cliente( bean );
			int resultado = cliente.gravar();
			if( resultado == 1 ) {
				request.setAttribute( "beanResultado", bean );				
				redirecionar("CadastroCliente.jsp", request, response);	
			} else {
				request.setAttribute("msgErro", "Não foi possível gravar o cliente!");
				request.setAttribute("paginaRetorno", "CadastroCliente.jsp");
				redirecionar("Erro.jsp", request, response);
			}
		}	
		else if( action.equals("Buscar") )
		{
			String cpf 	= request.getParameter("campoCPF");
			ClienteBean bean = new ClienteBean();
			bean.setCpf(cpf);
			Cliente c = new Cliente(bean);
			try {
				bean = c.pesquisar();
				if( bean != null ) {
					request.setAttribute("beanResultado", bean);
					redirecionar("CadastroCliente.jsp", request, response);	
				} else {
					request.setAttribute("msgErro", "Cliente não encontrado no sistema!");
					request.setAttribute("corMsgErro", "#0000FF");
					redirecionar("Erro.jsp", request, response);
				}
			} catch (Exception e) {
				String msg = e.getMessage();
				request.setAttribute("msgErro", msg);
				redirecionar("Erro.jsp", request, response);
			}
		}
		else if(action.equals("Alterar"))
		{				
			String id 	= request.getParameter("campoID");
			String nome = request.getParameter("campoNome");
			String cpf 	= request.getParameter("campoCPF");
			String endereco = request.getParameter("campoEndereco");
			String nickname = request.getParameter("campoNickname");
			String password = request.getParameter("campoPassword");
			String admin = request.getParameter("campoAdmin");
								
			ClienteBean bean = new ClienteBean();
			bean.setId(Integer.parseInt(id));
			bean.setNome(nome);
			bean.setCpf(cpf);
			bean.setEndereco(endereco);
			bean.setNickname(nickname);
			bean.setPassword(password);
			if( admin != null && admin.equals("1") ) {
				bean.setAdmin(true);
			}			
			Cliente c = new Cliente(bean);
			bean = c.alterar();
			if( bean != null ) {
				request.setAttribute( "beanResultado", bean );				
				redirecionar("CadastroCliente.jsp", request, response);	
			} else {
				request.setAttribute("msgErro", "Não foi possível alterar o cliente!");
				request.setAttribute("paginaRetorno", "CadastroCliente.jsp");
				redirecionar("Erro.jsp", request, response);
			}			
		} 			
		else if(action.equals("Excluir"))
		{
			String id = request.getParameter("campoID");
				
			ClienteBean bean = new ClienteBean();
			bean.setId(Integer.parseInt(id));
				
			Cliente cliente = new Cliente(bean);
			int resultado = cliente.excluir();
			if( resultado != 0 ) {
				request.setAttribute("chaveExcluir", resultado);
				redirecionar("InformarCep.jsp", request, response);	
			} else {
				request.setAttribute("msgErro", "Não foi possível excluir o cliente!");
				request.setAttribute("paginaRetorno", "CadastroCliente.jsp");
				redirecionar("Erro.jsp", request, response);
			}			
		} else {
			request.setAttribute("msgErro", "O sistema não compreendou a ação solicitada! (Ação: "+action+")!");
			redirecionar("Erro.jsp", request, response);
		}
	}
		
	private void redirecionar(String paginaDestino, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher( "/"+paginaDestino );
		dispatcher.forward( request, response );
	}
}
