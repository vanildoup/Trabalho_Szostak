<jsp:include page="header.jsp" flush="true">
	<jsp:param name="titleName" value="Autentica��o" />
</jsp:include>


<FORM name="f1" action="Login" method="Post">

Usu�rio <INPUT type="text" name="campoUser" value="" required="required">
<BR>
Senha <INPUT type="password" name="campoPassword" value="" required="required">
<BR>
<INPUT type="submit" name="btn" value="Autenticar">
</FORM>
<BR>
<jsp:include page="footer.jsp" flush="true"/>