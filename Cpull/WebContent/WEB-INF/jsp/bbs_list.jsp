<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>スレッド一覧</title>
	<link rel="stylesheet" href="/Cpull/css/bbs_list.css">
</head>
<body>
	<header>
	<!-- 後からヘッダー追加 -->
	</header>

	<main>
		<!-- サブメニュー追加 -->
		<h1>ここにスレッド一覧が表示される</h1>
		<c:forEach var="e" items="${bbsList}">
			<form method="POST" action="/Cpull/BbsDetailServlet">
			<input hidden type="submit" name="user_id" value="${e.user_id}">
			<input hidden type="submit" name="bbs_id" value="${e.bbs_id}">
			<input type="submit" name="bbs_title" value="${e.bbs_title}">
			<input hidden type="submit" name="bbs_details" value="${e.bbs_details}">
			<input hidden type="submit" name="bbs_pw" value="${e.bbs_pw}">
			<input hidden type="submit" name="bbs_range" value="${e.bbs_range}">
			<input hidden type="submit" name="bbs_category" value="${e.bbs_category}">
			<hr>
			</form>
		</c:forEach>
	</main>
</body>
</html>