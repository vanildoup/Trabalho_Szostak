<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<BR><BR>
<HR>
<% SimpleDateFormat sdf = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy 'as' HH:mm:ss"); %>

<H6 align="center"> <%=sdf.format(new Date())%> </H6>
</BODY>
</HTML>