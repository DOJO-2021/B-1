<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マイページ</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/mypage.css">
</head>
<body>
  <header>
    <jsp:include page = "/WEB-INF/jsp/header.jsp"/>
  </header>
  <main>
    <h1>マイページ</h1>

    <c:forEach var="e" items="${cardList}" >
		<form method="POST" action="/Cpull/MypageServlet">
		<input type="hidden" name="user_id" value="${e.user_id}"><br>
		<input type="text" name="user_name" value="${e.user_name}" readonly><br>
		<input type="text" name="user_pw" value="${e.user_pw}" disabled><br> <!-- パスワード非表示にしよう！ -->
		<input type="text" name="user_k_kana" value="${e.user_k_kana}"><br>
		<input type="text" name="user_company" value="${e.user_company}"><br>

		</form>
	</c:forEach>
  </main>
</body>
</html>