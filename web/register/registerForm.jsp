<%--
  Created by IntelliJ IDEA.
  User: hansol
  Date: 29/09/2018
  Time: 4:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/comm/header.jsp"/>

<form action="registerCheck.jsp" method="post" onsubmit="return validCheck()">

	<input type="text" placeholder="id" name="id" onclick="idValidCheck()">
	<input type="password" placeholder="pw" name="pw">
	<input type="password" placeholder="pwchk" name="pwchk">
	<input type="text" placeholder="writer" name="writer">
	<input type="email" placeholder="email" name="email">

	<input type="submit" value="회원가입">

</form>

<script type="text/javascript">

	function idValidCheck() {
		var url = "<%=request.getContextPath()%>/register/idCheck/idCheckCtrl.jsp?command=form";
		var title = "idCheckForm";
		var property = "width=200, height=200";
		window.open(url, title, property);
	}

	function validCheck() {

		var id = document.getElementsByName("id")[0].value;
		var pw = document.getElementsByName("pw")[0].value;
		var writer = document.getElementsByName("writer")[0].value;
		var email = document.getElementsByName("email")[0].value;

		return false;
	}

</script>




<jsp:include page="/comm/footer.jsp"/>