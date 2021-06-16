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
      <p>メールアドレスを入力してください<br>
      新しいID<input type="text" name="USER_ID"><br>
      <p>8文字以上16文字未満で登録してください
      <p>アルファベットと数字どちらも含むパスワードを設定してください<br>
      新しいPW<input type="text" name="USER_PW"><br>
      <p>氏名・よみかた・会社名を入力してください<br>
      <table>
        <tr>
          <td>氏名</td>
          <td><input type="text" name="USER_NAME"></td>
        </tr>
        <tr>
          <td>よみかた</td>
          <td><input type="text" name="USER_K_NAME"></td>
        </tr>
        <tr>
          <td>会社名</td>
          <td><input type="text" name="USER_COMPANY"></td>
        </tr>
      </table>
      受講者<input type="checkbox" name="" value="0">
      講師<input type="checkbox" name="" value="1">
      事務局<input type="checkbox" name="" value="2">
      その他<input type="checkbox" name="" value="3"><br>
      <input type="submit" name="REGIST" value="登録"><br>
    </form>
  </main>
</body>
</html>