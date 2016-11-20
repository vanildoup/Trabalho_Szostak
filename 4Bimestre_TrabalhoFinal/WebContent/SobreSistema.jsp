<%@include file="security.jsp" %>
<%@page import="edu.up.br.exemplo.model.ClienteBean"%>

<jsp:include page="header.jsp" flush="true">
	<jsp:param name="titleName" value="Menu"/>
</jsp:include>

<h3 align="center">Integrantes da Equipe</h3>
<ul class="list-group">
  <li class="list-group-item list-group-item-info" align="center">André Luiz Nunes Goulart</li>
  <li class="list-group-item list-group-item-info" align="center">Vanildo Prates</li>
  <li class="list-group-item list-group-item-info" align="center">João Victor Gonçalves Aracheski</li>
  <li class="list-group-item list-group-item-info" align="center">Felipe Borgo</li>
  <li class="list-group-item list-group-item-info" align="center">Paulo Gabriel França e Silva</li>
</ul>

<jsp:include page="footer.jsp" flush="true"/>