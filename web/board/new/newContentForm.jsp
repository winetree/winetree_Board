<%@ page import="wine.tree.member.dto.Member_Dto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../../comm/header.jsp"/>
<%
	String id = (String)session.getAttribute("id");
	Member_Dto dto = new Member_Dto();

	if (id == null) {
		response.sendRedirect("newContentCtrl.jsp?command=form");
	} else {
		dto = (Member_Dto)request.getAttribute("dto");
	}
%>



<form action="newContentCtrl.jsp" method="post">
	<input type="hidden" name="command" value="insert">

	<input type="text" readonly="readonly" name="id" value="<%=dto.getId()%>">
	<input type="text" readonly="readonly" name="writer" value="<%=dto.getWriter()%>">
	<input type="text" name="title">
	<input type="text" name="content">

	<input type="submit" value="글 등록하기">
	<input type="button" value="취소하기">
</form>




<jsp:include page="../../comm/footer.jsp"/>