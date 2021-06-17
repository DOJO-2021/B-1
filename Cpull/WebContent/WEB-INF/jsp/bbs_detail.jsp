<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.BBS" %>
<%@ page import="model.Reply" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String bbs_title = (String)request.getAttribute("bbs_id"); %>
<% String bbs_details = (String)request.getAttribute("bbs_details"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>掲示板詳細</title>
<link rel="stylesheet" href="/Cpull/css/bbs_detail.css">
<link rel="stylesheet" href="/Cpull/css/common.css">
<link rel="stylesheet" href="/Cpull/css/bbs_common.css">
</head>
<body>
<header>
    <jsp:include page = "/WEB-INF/jsp/header.jsp"/>
 </header>

<h1>掲示板詳細</h1>

タイトル<br>
	<p><%= bbs_title %></p><br>
内容<br>
	<p><%= bbs_details %></p><br>
コメント欄<br>
	<c:forEach var="r" items="${replyList}" >
		<p><c:out value="${r.reply_contents}"></c:out></p>

	</c:forEach>

<div>
<form action="Cpull/BbsDetailServlet" method="POST">
コメント<br>
	<textarea name="message"></textarea>
	<input type="submit" name="submit" value="回答"><br>
	匿名にする？<br>
	<input type="checkbox" name="how" value="name">
</form>
</div>
</body>
</html>