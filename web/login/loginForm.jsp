<%--
  Created by IntelliJ IDEA.
  User: winetree
  Date: 02/10/2018
  Time: 1:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../comm/header.jsp"/>

<form action="./loginCtrl.jsp" method="post">
	<input type="hidden" name="command" value="login">

	<input type="text" name="id" placeholder="id">
	<input type="text" name="pw" placeholder="pw">

	<input type="submit" value="로그인">

</form>

<jsp:include page="../comm/footer.jsp"/>