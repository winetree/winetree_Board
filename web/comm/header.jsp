<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
	<meta charset="UTF-8">
	<title>Winetree Home</title>
	<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic" rel="stylesheet">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/comm/src/css/style.css">
</head>
<%
	request.setCharacterEncoding("UTF-8");
	String id = (String)session.getAttribute("id");
	boolean loginChk = id!=null?true:false;
%>


<body>

<div id="navbar-container">
	<div class="navbar-width">

		<a href="<%=request.getContextPath()%>/index.jsp" class="navbar navbar-header">Winetree</a>
		<a href="#" class="navbar navbar-item">게시판</a>


	<% if (loginChk) { %>
		<a href="<%=request.getContextPath()%>/userInfo/userInfoCtrl.jsp?command=form" class="navbar navbar-item">내 정보</a>
		<a href="<%=request.getContextPath()%>/login/loginCtrl.jsp?command=logout" class="navbar navbar-item">로그아웃</a>

	<% } else {	%>
		<a href="<%=request.getContextPath()%>/register/registerCtrl.jsp?command=form" class="navbar navbar-item">회원가입</a>
		<a href="<%=request.getContextPath()%>/login/loginCtrl.jsp?command=form" class="navbar navbar-item">로그인</a>
	<% } %>
	</div>
</div>

<h1>
	<%=loginChk?id+" 님 환영합니다":"게시판 웹사이트!"%>
</h1>