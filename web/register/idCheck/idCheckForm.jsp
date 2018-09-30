<%--
  Created by IntelliJ IDEA.
  User: hansol
  Date: 30/09/2018
  Time: 10:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<%
		String str = (String)request.getAttribute("id");

		if(str != null && str == "") {

		}

%>

<form action="idCheckCtrl.jsp?command=idCheck" method="post" onsubmit="return true">

	<input type="text" name="id" placeholder="id">
	<input type="hidden" name="checked" value="false">
	<input type="button" value="중복 확인" name="idCheck">
	<input type="submit" value="사용하기">

</form>

</body>
</html>
