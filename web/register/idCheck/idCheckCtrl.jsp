<%@ page import="wine.tree.member.service.iMember_Service" %>
<%@ page import="wine.tree.member.service.Member_Service" %>
<%@ page import="wine.tree.member.dto.Member_Dto" %><%--
  Created by IntelliJ IDEA.
  User: hansol
  Date: 30/09/2018
  Time: 10:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%!

	iMember_Service service = new Member_Service();

	public boolean idCheck(String id) {
		Member_Dto dto = new Member_Dto();
		dto.setId(id);
		return service.idCheck(dto);
	}

%>
<%

	String command = request.getParameter("command");

	// command=form 전송시 idCheckForm 으로 리다이렉트
	if (command.equalsIgnoreCase("form")) {

		response.sendRedirect("idCheckForm.jsp");

		// command==idCheck 일시 중복아이디 판단.
	} else if(command.equalsIgnoreCase("idCheck")) {

			String id = request.getParameter("id");

		if(idCheck(id)){

			request.setAttribute("id", id);
			pageContext.forward("idCheckForm.jsp");

			System.out.println("사용 가능한 아이디");

		}
	}

%>