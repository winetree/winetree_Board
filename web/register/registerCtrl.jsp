<%@ page import="wine.tree.member.service.Member_Service" %>
<%@ page import="wine.tree.member.service.iMember_Service" %>
<%@ page import="wine.tree.member.dto.Member_Dto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

	iMember_Service service = new Member_Service();

	String command = request.getParameter("command");

	if (command.equalsIgnoreCase("form")) {
		response.sendRedirect("registerForm.jsp");
	} else if (command.equalsIgnoreCase("register")) {

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String writer = request.getParameter("writer");
		String email = request.getParameter("email");

		Member_Dto dto = new Member_Dto();

		dto.setId(id);
		dto.setPw(pw);
		dto.setWriter(writer);
		dto.setEmail(email);

		boolean isc = service.register(dto);

		if(isc) {
			request.setAttribute("dto", dto);
			pageContext.forward("./registered.jsp");
		} else {
			request.setAttribute("errMsg", "뭔가 실패");
			pageContext.forward("../comm/error.jsp");
		}

	}


%>
