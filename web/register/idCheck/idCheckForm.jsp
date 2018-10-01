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

<form action="idCheckCtrl.jsp?command=idCheck" method="post" onsubmit="return idSubmit();">
	<input type="text" name="id" placeholder="id">
	<input type="hidden" name="checked" value="false">
	<input type="button" name="중복확인" onclick="idCheck();">
	<input type="submit" value="사용하기">
</form>

<script type="text/javascript">

function idSubmit() {

	var id = document.getElementsByName("id")[0].value;
	var checked = document.getElementsByName("checked")[0].value;

	if(checked == "false") {
		alert("중복검사를 먼저 실행해 주세요.");
		return false;
	} else if(checked == "true") {
		return true;
	}
}

function idCheck() {



}


</script>

</body>
</html>
