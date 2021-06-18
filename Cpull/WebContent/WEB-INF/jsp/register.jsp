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
  <div class="wrapper">
    <h1 class="top_name">新規アカウント登録ページ</h1>

    <form method="POST" action="/Cpull/RegisterServlet">
      <p>新しいIDとPWを入力してください！<br>
      <p>メールアドレスを入力してください<br>
      新しいID<input type="text" name="USER_ID" placeholder="例:seplus@seplus2021.onmicrosoft.com" required><br>
      <p>8文字以上16文字未満で登録してください
      <p>アルファベットと数字どちらも含むパスワードを設定してください<br>
      新しいPW<input type="text" name="USER_PW" required><br>
      <p>氏名・よみかた・会社名を入力してください<br>
      <table>
        <tr>
          <td>氏名</td>
          <td><input type="text" name="USER_NAME" required></td>
        </tr>
        <tr>
          <td>よみかた</td>
          <td><input type="text" name="USER_K_NAME" required></td>
        </tr>
        <tr>
          <td>会社名</td>
          <td><input type="text" name="USER_COMPANY"required></td>
        </tr>
      </table>
      受講者<input type="radio" name="USER_CLASS" value="0" checked>
      講師<input type="radio" name="USER_CLASS" value="1">
      事務局<input type="radio" name="USER_CLASS" value="2">
     その他<input type="radio" name="USER_CLASS" value="3"><br>
      <input type="submit" name="REGIST" value="登録"><br>
    </form>
    </div>
  </main>
  <script src="/Cpull/js/register.js"></script>
</body>
</html>