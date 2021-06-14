<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント登録完了</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/r_result.css">
</head>
<body>
  <header>
    <jsp:include page = "/WEB-INF/jsp/header.jsp"/>
  </header>
  <main>
    <h1><c:out value="${r_result.title}" /></h1>
    <a href="${r_result.backTo}">ログインページへ</a>
  </main>
</body>
</html>