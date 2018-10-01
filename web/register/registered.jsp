<%@ page import="wine.tree.member.dto.Member_Dto" %><%--
  Created by IntelliJ IDEA.
  User: winetree
  Date: 02/10/2018
  Time: 2:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<body>


<%
	Member_Dto dto = (Member_Dto)request.getAttribute("dto");
%>

<%=dto%>

</body>
</html>
