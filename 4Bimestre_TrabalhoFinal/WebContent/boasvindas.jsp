<%@include file="security.jsp" %>
<%@page import="edu.up.br.exemplo.model.ClienteBean"%>

<jsp:include page="header.jsp" flush="true">
	<jsp:param name="titleName" value="Menu"/>
</jsp:include>

<H1 align="center"> Seja Bem vindo! <FONT color='#0000FF'><%=accessBean.getNome()%> </FONT></H1>

<BR>
<% if( accessBean.isAdmin() ) { %>
	<H3 align="center"> Olá! Você é um administrador! Deseja cadastrar um novo cliente? </H3>
	<P align="center"> <A href="InformarCep.jsp"> Clique Aqui! </A>  </P>
	<div class="btn-group" align="right">
	  <button type="button" class="btn btn-primary">Relatório de Clientes</button>
	  <button type="button" class="btn btn-primary">Cadastro de Produto</button>
	  <a href="SobreSistema.jsp"><button type="button" class="btn btn-primary">Sobre o Sistema</button></a>
	</div>
<% } %>

<BR>

<jsp:include page="footer.jsp" flush="true"/>
