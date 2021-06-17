<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>スレッド検索結果</title>
	<link rel="stylesheet" href="/Cpull/css/bbs_searchresult.css">
	<jsp:include page = "/WEB-INF/jsp/header.jsp"/>
</head>
<body>
	<div class="wrapper">
		<main>
			<!-- サブメニュー追加 -->
			<h1>検索結果</h1>
			${bbsList.size()}件ヒットしました！
			<c:forEach var="e" items="${bbsList}">
				<form method="POST" action="/Cpull/BbsDetailServlet">
				<input type="submit" name="bbs_title" value="${e.bbs_title}">
				<hr>
				</form>
			</c:forEach>
		</main>
	</div>
</body>
</html>