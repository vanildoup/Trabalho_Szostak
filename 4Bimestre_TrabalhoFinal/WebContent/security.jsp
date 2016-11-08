<%
edu.up.br.exemplo.model.ClienteBean accessBean = (edu.up.br.exemplo.model.ClienteBean)session.getAttribute("user");
if( accessBean == null ) { %>
	<jsp:forward page="Erro.jsp">
		<jsp:param value="Acesso Restrito" name="msgErro"/>
		<jsp:param value="login.jsp" name="paginaRetorno"/>
	</jsp:forward>	
<% } else { %>
	<FORM name="form" action="" method="Post">
		<P align="right"> <A href="#" onClick="logout()">Sair</a> </P>
	</FORM>
	<SCRIPT>
	function logout() {
		if( confirm("Deseja realmente sair?") ) {
			document.form.action="Logout";
			document.form.submit();
		}
	}
	</SCRIPT>
<% }  %>