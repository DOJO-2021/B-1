<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>スレッド検索結果</title>
	<link rel="stylesheet" href="/Cpull/css/bbs_searchresult.css">
</head>
<body>
	<header>
	<!-- 後からヘッダー追加 -->
	</header>

	<main>
		<!-- サブメニュー追加 -->
		<h1>ここにスレッドの検索結果が表示される</h1>
		<c:forEach var="e" items="${bbsList}">
			<form method="POST" action="/Cpull/BbsDetailServlet">
			<input type="submit" name="bbs_title" value="${e.bbs_title}">
			<hr>
			</form>
		</c:forEach>
	</main>
</body>
</html>