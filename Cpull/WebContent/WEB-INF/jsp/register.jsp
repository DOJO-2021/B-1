<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規アカウント登録</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/register.css">
</head>
<body>
  <header>
    <jsp:include page = "/WEB-INF/jsp/header.jsp"/>
  </header>
  <main>
    <h1>新規アカウント登録ページ</h1><br>
    <form method="POST" action="/Cpull/RegisterServlet">
      <p>新しいIDとPWを入力してください！
      <p>メールアドレスを入力してください
      新しいID<input type="text" name=""><!-- name属性未定 --><br>
      <p>8文字以上16文字未満で登録してください
      <p>アルファベットと数字どちらも含むパスワードを設定してください
      新しいPW<input type="text" name=""><!-- name属性未定 --><br>
      <p>氏名・よみかた・会社名を入力してください
      氏名<input type="text" name=""><!-- name属性未定 --><br>
      よみかた<input type="text" name=""><!-- name属性未定 --><br>
      会社名<input type="text" name=""><!-- name属性未定 --><br>
      受講者<input type="checkbox" name="" value="students"><!-- name属性未定 -->
      講師・事務局<input type="checkbox" name="" value="students"><!-- name属性未定 --><br>
      <input type="submit" name="REGIST" value="登録"><br>
    </form>
  </main>
</body>
</html>