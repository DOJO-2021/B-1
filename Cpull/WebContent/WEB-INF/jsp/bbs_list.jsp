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
			スレッド${e.bbs_title}
		</c:forEach>
	</main>
</body>
</html>