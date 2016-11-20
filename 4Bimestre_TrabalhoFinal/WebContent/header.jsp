<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
	<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<% 
	String titleName = "SISTEMA EXEMPLO ("; 
	titleName += request.getParameter("titleName");
	titleName += ")";
	%>
	<TITLE> <%=titleName%> </TITLE>
</HEAD>
<BODY>
<H2 align="center"> <%=request.getParameter("titleName")%> </H2>
<HR>
<BR>