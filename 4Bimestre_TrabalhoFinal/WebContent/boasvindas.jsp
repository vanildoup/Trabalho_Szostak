<%@include file="security.jsp" %>
<%@page import="edu.up.br.exemplo.model.ClienteBean"%>

<jsp:include page="header.jsp" flush="true">
	<jsp:param name="titleName" value="Menu"/>
</jsp:include>

<H1 align="center"> Seja Bem vindo! <FONT color='#0000FF'><%=accessBean.getNome()%> </FONT></H1>

<BR>
<% if( accessBean.isAdmin() ) { %>
	<H3 align="center"> Ol�! Voc� � um administrador! Deseja cadastrar um novo cliente? </H3>
	<P align="center"> <A href="InformarCep.jsp"> Clique Aqui! </A>  </P>
<% } %>

<BR>

<jsp:include page="footer.jsp" flush="true"/>
