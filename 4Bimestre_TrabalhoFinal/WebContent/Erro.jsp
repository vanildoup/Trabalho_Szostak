<jsp:include page="header.jsp" flush="true">
	<jsp:param name="titleName" value="Página de Erro"/>
</jsp:include>
<%
String mensagem = (String)request.getAttribute("msgErro");
String cor = (String)request.getAttribute("corMsgErro");
if( mensagem == null ) {
	mensagem = request.getParameter("msgErro");
	if( mensagem == null ) {
		mensagem = "Erro no sistema!";
	}	
}
if( cor == null ) {
	cor = "#FF0000";
}
String paginaRetorno = (String)request.getAttribute("paginaRetorno");
if( paginaRetorno != null ) {
	paginaRetorno = "javascript:location.href='"+paginaRetorno+"'";
} else {
	paginaRetorno = request.getParameter("paginaRetorno");
	if( paginaRetorno != null ) {
		paginaRetorno = "javascript:location.href='"+paginaRetorno+"'";
	} else {
		paginaRetorno = "javascript:history.back()";
	}
}
%>
<H1 align="center"> MENSAGEM: <FONT color="<%=cor%>"><%=mensagem%></FONT> </H1>
<BR><BR>
<P align="center">
	<INPUT type="button" name="btn" value="Voltar" onclick="<%=paginaRetorno%>">
</P>

<jsp:include page="footer.jsp" flush="true"/>