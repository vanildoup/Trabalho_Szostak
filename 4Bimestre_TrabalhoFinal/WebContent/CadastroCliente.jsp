<%@include file="security.jsp" %>
<%@page import="edu.up.br.exemplo.model.ClienteBean"%>

<jsp:include page="header.jsp" flush="true">
		<jsp:param name="titleName" value="Cadastro de Cliente"/>
	</jsp:include>
<FORM name="f1" action="" method="Post"> 

<% 
/////////////////////////GRAVAR
String action = request.getParameter("acao");
if(action == null) {
	action = "";
}
ClienteBean bean = (ClienteBean)request.getAttribute("beanResultado");
if( bean != null ) {
	if( bean.getId() != 0 && action.equals("Gravar") ) {
		out.print("<SCRIPT>alert('Salvo com sucesso!')</SCRIPT>");
	}
	if( bean.getId() != 0 && action.equals("Alterar") ) {
		out.print("<SCRIPT>alert('Alterado com sucesso!')</SCRIPT>");
	}
} else {
	bean = new ClienteBean();
}
String endereco = (String)request.getAttribute("chaveEndereco");
if( endereco == null || endereco.equalsIgnoreCase("")) {
	endereco = bean.getEndereco();
	if( endereco == null ) {
		endereco = "Não foi possível localizar o endereço!";	
	}
}
%>


<INPUT type="hidden" name="campoID" value="<%=bean.getId()%>" >
Nome <INPUT type="text" name="campoNome" value="<%=bean.getNome()%>" size="60">
<BR>
Endereço <INPUT type="text" name="campoEndereco" value="<%=endereco%>" size="60">
<BR>
CPF <INPUT type="text" name="campoCPF" value="<%=bean.getCpf()%>" size="15" maxlength="11">
 &nbsp; <INPUT type="button" name="btn" value="Pesquisar" onClick="enviar('Pesquisar')">
 <BR>
Nickname  <INPUT type="text" name="campoNickname" value="<%=bean.getNickname()%>" size="30" maxlength="25">
<BR>
<% if( bean.getId() == 0 ) { %>
	Password  <INPUT type="text" name="campoPassword" value="" size="30" maxlength="10">
	<BR>
<% }
String admin = "";
if( bean.isAdmin() ) {
	admin = "CHECKED";
} %>
Administrador <INPUT type="checkbox" name="campoAdmin" value="1" <%=admin%>>

<BR><BR><BR>

<% if( bean.getId() == 0 ) { %>
	<INPUT type="button" name="btn" value="Gravar" onClick="enviar('Gravar')">
<% } else { %>	
	<INPUT type="button" name="btn" value="Alterar" onClick="enviar('Alterar')">
	<INPUT type="button" name="btn" value="Excluir" onClick="enviarExcluir()">
<% } %>

<BR><BR><BR><BR>

<SCRIPT>
function enviar(acao) {
	if( document.f1.campoNome.value == "" ) { alert("Campo Nome é Obrigatório"); return; }
	if( document.f1.campoEndereco.value == "" ) { alert("Campo Endereço é Obrigatório"); return; }
	if( document.f1.campoCPF.value == "" ) { alert("Campo CPF é Obrigatório"); return; }
	document.f1.action="CadastroServlet?acao="+acao;
	document.f1.submit();
}
function enviarExcluir() {
	if( confirm("Deseja realmente excluir?") ) {
			document.f1.action="CadastroServlet?acao=Excluir";
			document.f1.submit();
	}
}
</SCRIPT>

</FORM>

<jsp:include page="footer.jsp" flush="true"/>
