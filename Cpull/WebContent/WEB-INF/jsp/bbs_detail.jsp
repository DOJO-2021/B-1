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
			<c:out value="${r.user_name}"></c:out>:<c:out value="${r.reply_contents}"></c:out>
		</p>

	</c:forEach>
	<form action="/Cpull/BbsDetailServlet2" method="POST">
			<input type="hidden" name="bbs_id" value="${bbsList.get(0).bbs_id}">
			 コメント<br>
			<textarea name="reply_contents"></textarea><br>
		<!-- 	氏名の公開範囲<br>-->
			<input type="hidden" name="reply_range" value="0">
			<!-- 公開する<input type="radio" name="reply_range" value="1">-->
			<div>
				<input type="submit" name="submit" value="回答"><br>
			</div>
		</form>
</body>
</html>