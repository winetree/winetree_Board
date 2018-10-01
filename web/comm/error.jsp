<%--
  Created by IntelliJ IDEA.
  User: hansol
  Date: 30/09/2018
  Time: 10:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="./header.jsp"/>
<%

	String errMsg = (String)request.getAttribute("errMsg");

%>

<h2>에러 페이지 입니다.</h2>

<%=errMsg%>

<jsp:include page="./footer.jsp"/>