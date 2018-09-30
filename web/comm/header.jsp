<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
	<meta charset="UTF-8">
	<title>Winetree Home</title>
	<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic" rel="stylesheet">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/comm/src/css/style.css">
</head>

<body>

<div id="navbar-container">
	<div class="navbar-width">

		<a href="#" class="navbar navbar-header">Winetree</a>
		<a href="#" class="navbar navbar-item">게시판</a>
		<a href="<%=request.getContextPath()%>/register/registerCtrl.jsp?command=form" class="navbar navbar-item">회원가입</a>
		<a href="#" class="navbar navbar-item">로그인</a>
	</div>
</div>

<h1>
	hello world!
</h1>