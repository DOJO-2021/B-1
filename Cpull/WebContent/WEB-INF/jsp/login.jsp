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
	<div class="wrapper">
		<header>
			<h1 class="logo">
				<img src="images/Cpull_logo.png" alt="CpullLOGO" width="240"
					height="130">
			</h1>
		</header>
	</div>
	<main>
		<form method="POST" action="/Cpull/LoginServlet" id="form">
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
			<div>
				<input type="submit" name="LOGIN" value="ログイン" class="button">
			</div>
		</form>
		<div>
			<p id="output"></p>
		</div>
		<div class="create">
			<a href="/Cpull/RegisterServlet">アカウント作成はこちらから</a>
		</div>
	</main>
	<script src="/Cpull/js/login.js"></script>
<footer>
  <br> <br> <br> <br> <br>
  <br> <br> <br> <br> <br> <br>
</footer>
</body>
</html>