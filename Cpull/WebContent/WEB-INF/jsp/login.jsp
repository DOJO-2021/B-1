<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/login.css">
</head>
<body>
  <header>
    <jsp:include page = "/WEB-INF/jsp/header.jsp"/>
  </header>
  <main>
    <form method="POST" action="/Cpull/LoginServlet">
      <table>
        <tr>
          <td>ID</td>
          <td><input type="text" name="ID"></td>
        </tr>
        <tr>
          <td>PW</td>
          <td><input type="password" name="PW"></td>
        </tr>
      </table>
      <input type="submit" name="LOGIN" value="ログイン">
    </form>
    <a href="/Cpull/RegisterServlet">アカウント作成はこちらから</a>
  </main>
</body>
</html>