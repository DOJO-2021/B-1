<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <form method="POST" action="/Cpull/RegisterServlet">
      <input type="hidden" name="USER_ID">
      <input type="text" name="USER_NAME" readonly>
      <input type="text" name="USER_PW"> <!-- パスワード非表示/パスワード変更可？ -->
      <input type="text" name="USER_K_NAME">
      <input type="text" name="USER_COMPANY">
      <input type="text" name="USER_CLASS">
      <input type="text" name="USER_PREFECTURE">
      <input type="text" name="USER_HOBBY">
      <input type="text" name="USER_SKILL">
      <input type="text" name="USER_BIRTH">
      <input type="text" name="USER_PW">
    </form>
  </main>
</body>
</html>