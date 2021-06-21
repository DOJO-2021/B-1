<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.BBS"%>
<%@ page import="model.Reply"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
		<jsp:include page="/WEB-INF/jsp/header.jsp" />
	</header>

	<h1>スレッド詳細</h1>

	タイトル<br>
	<p>${bbsList.get(0).bbs_title}</p><br>
	 内容<br>
	<p>${bbsList.get(0).bbs_details}</p><br>
	 コメント欄<br>
		<c:forEach var="r" items="${replyList}">
			<p>
				<c:out value="${r.reply_contents}"></c:out>
			</p>
			<form action="/Cpull/BbsDetailServlet" method="POST">
				<input type="hidden"name="bbs_id" value="${r.bbs_id}">
				<input type="hidden"name="user_id" value="${r.user_id}">
				 <input type="hidden" name="user_name" value="${r.user_name}">
				 コメント<br>
				<textarea name="reply_contents"></textarea>
				<div>
					<input type="submit" name="submit" value="回答"><br>
				</div>
				氏名の公開範囲<br>
				匿名する<input type="radio" name="reply_range" value="0">
				公開する<input type="radio" name="reply_range" value="1">
			</form>
		</c:forEach>
</body>
</html>