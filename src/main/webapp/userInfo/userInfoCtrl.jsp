<%@ page import="wine.tree.member.service.iMember_Service" %>
<%@ page import="wine.tree.member.service.Member_Service" %>
<%@ page import="wine.tree.member.dto.Member_Dto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	request.setCharacterEncoding("UTF-8");

	String command = request.getParameter("command");
	String id = (String)session.getAttribute("id");
	Member_Dto dto = new Member_Dto();
	dto.setId(id);
	System.out.println(id);
	request.removeAttribute("dto");

	iMember_Service service = new Member_Service();

	if(id == null) {
		request.setAttribute("errMsg", "로그인이 필요합니다.");
		pageContext.forward("../comm/error.jsp");

	} else if(command.equalsIgnoreCase("form")) {

		Member_Dto result = service.getUserInfo(dto.getId());

		session.setAttribute("dto", result);
		pageContext.forward("userInfoForm.jsp");

	} else if(command.equalsIgnoreCase("update")) {

		String oldPw = request.getParameter("oldPassword");
		String newPw = request.getParameter("newPassword");
		String email = request.getParameter("email");
		String writer = request.getParameter("writer");

		Member_Dto oldDto = new Member_Dto();
		oldDto.setId(id);
		oldDto.setPw(oldPw);

		if (service.pwCheck(oldDto)) {
			Member_Dto dtoForUpdate = new Member_Dto();

			dtoForUpdate.setId(id);
			dtoForUpdate.setPw(newPw);
			dtoForUpdate.setEmail(email);
			dtoForUpdate.setWriter(writer);

			service.updateMember(dtoForUpdate);

			response.sendRedirect("../index.jsp");

		} else {
			System.out.println("비밀번호가 일치하지 않습니다.");
			request.setAttribute("msg", "기존 비밀번호가 일치하지 않습니다.");
			pageContext.forward("userInfoForm.jsp");

			response.sendRedirect("../index.jsp");
		}
	}




%>