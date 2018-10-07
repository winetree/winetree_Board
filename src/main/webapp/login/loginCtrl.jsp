<%@ page import="wine.tree.member.service.Member_Service" %>
<%@ page import="wine.tree.member.service.iMember_Service" %>
<%@ page import="wine.tree.member.dto.Member_Dto" %><%--
  Created by IntelliJ IDEA.
  User: winetree
  Date: 02/10/2018
  Time: 1:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	String command = request.getParameter("command");
	iMember_Service service = new Member_Service();

	if(command == null | command == "" | command == "null") {
		request.setAttribute("errMsg", "잘못된 접근입니다.");
		pageContext.forward("../comm/error.jsp");
	} else if(command.equalsIgnoreCase("form")) {
		response.sendRedirect("./loginForm.jsp");
	} else if(command.equalsIgnoreCase("login")) {

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		Member_Dto dto = new Member_Dto();
		dto.setId(id);
		dto.setPw(pw);

		boolean isc = service.login(dto);

		if(isc) {
			System.out.println("로그인에 성공하였습니다.");
			session.setAttribute("id", dto.getId());
			response.sendRedirect("../index.jsp");
		} else {
			System.out.println("로그인에 실패하였습니다.");
			response.sendRedirect("./loginCtrl.jsp?command=form");
		}

	} else if(command.equalsIgnoreCase("logout")) {
		session.invalidate();
		response.sendRedirect("../index.jsp");
	}

%>
