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
      <input type="text" name="USER_ID" readonly><br>
      <input type="hidden" name="USER_PW"> <!-- パスワード非表示/パスワード変更可？ -->
      <input type="text" name="USER_IMAGE"><br>
      ※氏名<input type="text" name="USER_NAME"><br> <!-- どうやって名前取り出す？ -->
      ※よみかた<input type="text" name="USER_K_NAME"><br>
      ※会社名<input type="text" name="USER_COMPANY"><br>
      出身<input type="text" name="USER_PREFECTURE"><br>
      趣味<input type="text" name="USER_HOBBY"><br>
      特技<input type="text" name="USER_SKILL"><br>
      誕生日<input type="text" name="USER_BIRTH"><br>
      備考<input type="text" name="USER_REMARKS"><br>
      <input type="text" name="USER_CLASS" readonly><br><!-- ※受講者/運営表示させる -->
      <input type="text" name="USER_RANGE"><br><!-- 公開範囲 -->
    </form>
  </main>
</body>
</html>