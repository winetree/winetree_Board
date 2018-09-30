<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

	String command = request.getParameter("command");

	if (command.equalsIgnoreCase("form")) {
		response.sendRedirect("registerForm.jsp");
	}


%>
