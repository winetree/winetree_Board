<%@ page import="wine.tree.member.service.iMember_Service" %>
<%@ page import="wine.tree.member.service.Member_Service" %>
<%@ page import="wine.tree.member.dto.Member_Dto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	request.setCharacterEncoding("UTF-8");

	String command = request.getParameter("command");
	String id = (String)session.getAttribute("id");
	System.out.println(id);
	request.removeAttribute("dto");

	iMember_Service service = new Member_Service();

	if(id == null) {
		request.setAttribute("errMsg", "로그인이 필요합니다.");
		pageContext.forward("../comm/error.jsp");

	} else if(command.equalsIgnoreCase("form")) {

		Member_Dto dto = service.getUserInfo(id);

		session.setAttribute("dto", dto);
		pageContext.forward("userInfoForm.jsp");

	} else if(command.equalsIgnoreCase("update")) {

		Member_Dto oldDto = service.getUserInfo(id);
		Member_Dto newDto = new Member_Dto();

		String oldPw = request.getParameter("oldPassword");
		String newPw = request.getParameter("newPassword");
		String email = request.getParameter("email");
		String writer = request.getParameter("writer");

		System.out.println(oldPw);

		if (!oldPw.equals(oldDto.getPw())) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			request.setAttribute("msg", "기존 비밀번호가 일치하지 않습니다.");
			pageContext.forward("userInfoForm.jsp");
		} else {
			newDto.setId(id);
			newDto.setPw(newPw);
			newDto.setEmail(email);
			newDto.setWriter(writer);

			service.updateMember(newDto);

			response.sendRedirect("../index.jsp");
		}
	}




%>