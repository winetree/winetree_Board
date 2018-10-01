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
	request.setCharacterEncoding("UTF-8");

	String isc = (String) request.getAttribute("checked");
	String id = "";
	if (isc.equalsIgnoreCase("true")) {
		id = (String)request.getAttribute("id");
	}

%>

<form action="idCheckCtrl.jsp" method="post" onsubmit="return idSubmit();">
	<input type="hidden" name="command" value="idCheck">

	<input type="hidden" name="checked" id="checked" value=<%=isc%>>
	<input type="text" name="id" id="id" placeholder="id" value="<%=id%>">

	<input type="button" value="중복확인" onclick="idCheck()">
	<input type="submit" value="사용하기">

</form>

<script type="text/javascript">

	window.onload = function () {
		var msg = "<%=request.getAttribute("msg")%>";

		if (msg != "init") {
			alert(msg);
		}

		document.getElementById("id").addEventListener("input", checkedDefault);
	}

	/**
	 * 아이디의 value 가 변화할경우 checked가 false로 전환
	 */
	function checkedDefault() {
		document.getElementById("checked").value = "false";
	}

	/**
	 * id 유효성 검사 및 중복검사 method
	 * idCheckCtrl로 이동
	 */
	function idCheck() {
		var id = document.getElementById("id");

		if (id.value == null | id.value == "" | id.value == undefined) {
			alert("값을 입력하세요");
		}

//   유효성 검사
		else if (id.value.length < 8) {
			alert("아이디는 8자 이상이여야 합니다.");
		}
		else {
			var form = document.forms[0];
			form.action = "idCheckCtrl.jsp?command=idCheck";
			form.method = "post";
			form.submit();
		}
	}

	/**
	 * id 사용하기 Button
	 * @returns {boolean}
	 */
	function idSubmit() {

		var checked = document.getElementsByName("checked")[0];

		if (checked.value == "false") {
			alert("중복검사를 먼저 실시해주세요.");
		} else {
			opener.document.getElementById("id").value = "<%=id%>";
			window.close();
		}
			return false;
	}

</script>

</body>
</html>
