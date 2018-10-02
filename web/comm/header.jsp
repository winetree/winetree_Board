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
	String loginId = (String)session.getAttribute("login");

	boolean loginChk = loginId!=null?true:false;

%>


<body>

<div id="navbar-container">
	<div class="navbar-width">

		<a href="<%=request.getContextPath()%>/index.jsp" class="navbar navbar-header">Winetree</a>
		<a href="#" class="navbar navbar-item">게시판</a>


	<% if (loginChk) { %>
		<a href="<%=request.getContextPath()%>/register/registerCtrl.jsp?command=form" class="navbar navbar-item">내 정보</a>
		<a href="<%=request.getContextPath()%>/login/loginCtrl.jsp?command=logout" class="navbar navbar-item">로그아웃</a>
	<% } else {	%>
		<a href="<%=request.getContextPath()%>/register/registerCtrl.jsp?command=form" class="navbar navbar-item">회원가입</a>
		<a href="<%=request.getContextPath()%>/login/loginCtrl.jsp?command=form" class="navbar navbar-item">로그인</a>
	<% } %>
	</div>
</div>

<h1>
	hello world!
</h1>