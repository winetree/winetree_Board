<%@ page import="wine.tree.member.dto.Member_Dto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../comm/header.jsp"/>

<%
	Member_Dto dto = (Member_Dto)request.getAttribute("dto");
%>

<p>회원가입이 완료되었습니다.</p>

<jsp:include page="../comm/footer.jsp"/>