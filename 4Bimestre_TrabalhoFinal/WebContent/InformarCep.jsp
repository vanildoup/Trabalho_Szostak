<%@include file="security.jsp" %>

<jsp:include page="header.jsp" flush="true">
	<jsp:param name="titleName" value="Informar CEP" />
</jsp:include>

<FORM name="f1" action="ValidadorCEP" method="Post">

CEP <INPUT type="text" name="campoCEP" value="" size="10" required>

<INPUT type="submit" name="botao" value="Buscar">

</FORM>

<jsp:include page="footer.jsp" flush="true"/>