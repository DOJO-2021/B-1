<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>新規アカウント登録</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/register.css">
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
</head>

<body>
  <header>
    <jsp:include page = "/WEB-INF/jsp/header.jsp"/>
  </header>

  <main>
  <div class="wrapper">
    <h1 class="top_name">新規アカウント登録ページ</h1>

    <form class method="POST" action="/Cpull/RegisterServlet">
    <div class="box">
      <p>新しいIDとPWを入力してください！<br>
      <p>メールアドレスを入力してください<br>
      <table>
        <tr>
          <td>新しいID</td>
          <td><input class="" type="email" name="USER_ID" placeholder="例:seplus@seplus2021.onmicrosoft.com" required></td>
        </tr>
      </table>
      <p>8文字以上16文字未満で登録してください
      <p>アルファベットと数字どちらも含むパスワードを設定してください<br>
      <table>
        <tr>
          <td>新しいPW</td>
          <td>
            <input type="password" id="textPassword" name="USER_PW" pattern="[a-zA-Z0-9_-]{8,15}" required title="8文字以上16文字未満、半角英数字は必須です">
            <span id="buttonEye" class="fa fa-eye" onclick="pushHideButton()"></span>
          </td>
        </tr>
      </table>
      <p>氏名・よみかた・会社名を入力してください<br>
      <table>
        <tr>
          <td>氏名</td>
          <td><input type="text" name="USER_NAME" required title="氏名は必須項目です"></td>
        </tr>
        <tr>
          <td>よみかた</td>
          <td><input type="text" name="USER_K_NAME" required title="よみかたは必須項目です"></td>
        </tr>
        <tr>
          <td>会社名</td>
          <td><input type="text" name="USER_COMPANY"required title="会社名は必須項目です"></td>
        </tr>
      </table>
      受講者<input type="radio" name="USER_CLASS" value="0" checked>
      講師<input type="radio" name="USER_CLASS" value="1">
      事務局<input type="radio" name="USER_CLASS" value="2">
     その他<input type="radio" name="USER_CLASS" value="3"><br>
      <input type="submit" name="REGIST" value="登録" class="button"><br>
   </div>
    </form>
    <p id="output"></p>
    </div>
  </main>
  <script src="/Cpull/js/register.js"></script>
</body>
</html>