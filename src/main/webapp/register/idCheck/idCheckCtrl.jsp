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

	// Dao 객체화
	iMember_Service service = new Member_Service();

%>
<%

	// Id 중복확인 여부의 디폴트값 세팅 후 Form 에 전달
	request.setCharacterEncoding("UTF-8");
	request.setAttribute("checked", "false");
	// 부모 window 에게서 받아온 parameter 값 저장
	String command = request.getParameter("command");
	// 알림창 설정
	request.setAttribute("msg", "init");

	// command==form : idCheckForm 으로 리다이렉트
	if (command.equalsIgnoreCase("form")) {

		pageContext.forward("idCheckForm.jsp");

		// command==idCheck : 중복아이디 판단.
	} else if(command.equalsIgnoreCase("idCheck")) {
			String id = request.getParameter("id");

		if(service.idCheck(id)){
			request.setAttribute("id", id);
			request.setAttribute("checked", "true");
			request.setAttribute("msg","사용 가능한 아이디 입니다.");
			pageContext.forward("idCheckForm.jsp");

		} else {
			request.setAttribute("msg", "사용 불가능한 아이디 입니다.");
			pageContext.forward("idCheckForm.jsp");
		}
	} else if(command.equalsIgnoreCase("logout")) {
		session.invalidate();
		response.sendRedirect("../index.jsp");
	}

%>