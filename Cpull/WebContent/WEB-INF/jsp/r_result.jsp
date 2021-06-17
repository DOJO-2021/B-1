<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント登録完了</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/r_result.css">
</head>
<body>
<div class="wrapper">
  <header>
    <jsp:include page = "/WEB-INF/jsp/header.jsp"/>
  </header>
  <main>
    <h1 class="top_name"><c:out value="${result.title}" /></h1>
    <a href="${result.backTo}">ログインページへ</a>
  </main>
</div>
</body>
</html>