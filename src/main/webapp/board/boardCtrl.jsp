<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="wine.tree.board.service.*" %>
<%@ page import="wine.tree.board.dto.Board_Dto" %>
<%@ page import="java.util.List" %>
<%@ page import="wine.tree.member.service.*" %>
<jsp:include page="../comm/header.jsp"/>
<%

	iBoard_Service boardService = new Board_Service();
	String command = request.getParameter("command");

	if (command == null || command.equalsIgnoreCase("")) {
		request.setAttribute("errMsg", "잘못된 접근입니다.");
		pageContext.forward("../comm/error.jsp");

	} else if (command.equalsIgnoreCase("form")) {
		List<Board_Dto> lists = boardService.getAllBoard();
		request.setAttribute("lists", lists);
		pageContext.forward("boardForm.jsp");

		// 새로운 게시물 작성
	} else if (command.equalsIgnoreCase("newContent")) {
		response.sendRedirect("new/newContentCtrl.jsp?command=form");

	} else {
		request.setAttribute("errMsg", "잘못된 접근입니다.");
		pageContext.forward("../comm/error.jsp");
	}
%>
<jsp:include page="../comm/footer.jsp"/>