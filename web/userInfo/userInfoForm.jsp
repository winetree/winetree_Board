<%@ page import="wine.tree.member.dto.Member_Dto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../comm/header.jsp"/>
<%
	String id = (String) session.getAttribute("id");

	Member_Dto dto = (Member_Dto) session.getAttribute("dto");

	if (id == null) {
		request.setAttribute("errMsg", "로그인이 필요합니다.");
		pageContext.forward("../comm/error.jsp");
	} else if (id != null && id != "" && id != "null") {

	}
%>

<div class="container">
	<div class="grid-item-col-12">
		<form action="userInfoCtrl.jsp" method="post">
			<input type="hidden" name="command" value="update">

			<p>아이디</p><input type="text" name="id" value="<%=dto.getId()%>" readonly="readonly"><br>

			<p>이메일</p><input type="text" name="email" value="<%=dto.getEmail()%>"><br>

			<p>닉네임</p><input type="text" name="writer" value="<%=dto.getWriter()%>"><br>

			<p>가입날짜 : <%=dto.getRegdate()%></p><br>

			<p>기존 비밀번호 입력 :</p> <input type="password" name="oldPassword"><br>

			<p>신규 패스워드 입력 :</p> <input type="password" name="newPassword"><br>

			<p>신규 패스워드 다시 입력 : </p> <input type="password" name="newPasswordR"><br>

			<input type="submit" value="수정하기"><br>
		</form>
	</div>
</div>
<jsp:include page="../comm/footer.jsp"/>