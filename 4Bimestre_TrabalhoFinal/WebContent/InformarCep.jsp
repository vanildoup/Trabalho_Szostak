<%@include file="security.jsp" %>

<jsp:include page="header.jsp" flush="true">
	<jsp:param name="titleName" value="Informar CEP" />
</jsp:include>

<FORM name="f1" action="ValidadorCEP" method="Post">

CEP <INPUT type="text" name="campoCEP" value="" size="10" required>

<INPUT type="submit" name="botao" value="Buscar">

</FORM>

<BR>OU<BR><BR>

<FORM name="f2" action="CadastroServlet" method="Post">

CPF<INPUT type="text" name="campoCPF" value"" size="10" required>

<INPUT type="submit" name="acao" value="Buscar">

</FORM>

<jsp:include page="footer.jsp" flush="true"/>