<%@ page import="wine.tree.member.dto.Member_Dto" %>
<%@ page import="wine.tree.board.service.iBoard_Service" %>
<%@ page import="wine.tree.board.service.Board_Service" %>
<%@ page import="wine.tree.member.service.iMember_Service" %>
<%@ page import="wine.tree.member.service.Member_Service" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

	iBoard_Service boardService = new Board_Service();
	iMember_Service memberService = new Member_Service();
	String command = request.getParameter("command");
	String id = (String)session.getAttribute("id");
	boolean login = id!=null?true:false;

	if(!login) {
		request.setAttribute("errMsg", "로그인이 필요합니다.");
		pageContext.forward("../../comm/error.jsp");
	}

	else if (command == null) {
		request.setAttribute("errMsg", "잘못된 접근입니다.");
		pageContext.forward("../../comm/error.jsp");
	}

	else if(command.equalsIgnoreCase("form")){

		Member_Dto temp = new Member_Dto();
		temp.setId(id);

		Member_Dto dto = memberService.getUserInfo(temp);

		request.setAttribute("dto", dto);
		pageContext.forward("newContentForm.jsp");
	}

	else if(command.equalsIgnoreCase("insert")){



	}

	else {

		request.setAttribute("errMsg", "잘못된 접근입니다.");
		pageContext.forward("../../comm/error.jsp");
	}

%>