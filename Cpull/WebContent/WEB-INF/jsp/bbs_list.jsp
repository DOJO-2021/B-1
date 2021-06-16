<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>スレッド一覧</title>
	<link rel="stylesheet" href="/Cpull/css/bbs_list.css">
	<jsp:include page = "/WEB-INF/jsp/header.jsp"/>
</head>
<body>
	<header>
	<!-- 後でヘッダー追加 -->
	</header>

	<main>
		<!-- 後でサブメニュー追加 -->
		<h1>ここにスレッドの一覧が表示される</h1>
		<c:forEach var="e" items="${bbsList}">
			<form method="POST" action="/Cpull/BbsDetailServlet">
			<input type="submit" name="bbs_title" value="${e.bbs_title}">
			<hr>
			</form>
		</c:forEach>
	</main>
</body>
</html>