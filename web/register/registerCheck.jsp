<%@ page import="wine.tree.member.service.Member_Service" %>
<%@ page import="wine.tree.member.service.iMember_Service" %>
<%@ page import="wine.tree.member.dto.Member_Dto" %><%--
  Created by IntelliJ IDEA.
  User: hansol
  Date: 30/09/2018
  Time: 9:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/comm/header.jsp"/>
<%

	iMember_Service dao = new Member_Service();

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String writer = request.getParameter("writer");
	String email = request.getParameter("email");

	Member_Dto dto = new Member_Dto();

	dto.setId(id);
	dto.setPw(pw);
	dto.setWriter(writer);
	dto.setEmail(email);

	boolean usableID = dao.idCheck(dto);

	if(usableID) {
		dao.register(dto);
	} else {
		System.out.println("아이디 중복으로 인한 회원가입 실패");
	}

%>

<h2>id : <%=id%> / pw : <%=pw%> / writer : <%=writer%> / email : <%=email%></h2>


<jsp:include page="/comm/footer.jsp"/>