<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>メニュー</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/menu.css">
</head>

<body>
	<header>
	<h1 class="logo">
     <img src="images/Cpull_logo.png" alt="CpullLOGO" width="240" height="130">
  	</h1>
	</header>

	<main>
		<div class = "wrapper">
		<h1 class="top_name">メニュー</h1>
		<div class="menu_box">
			<table>
			<tr>
			<td><a href="/Cpull/ProfileServlet" class="button">自己紹介</a></td>
			<td><a href="/Cpull/TalkroomServlet" class="button">トークルーム</a></td>
			</tr>
			<tr>
			<td><a href="/Cpull/BbsServlet" class="button">掲示板</a></td>
			<td><a href="/Cpull/MypageServlet" class="button">マイページ</a></td>
			</tr>
			<tr>
			<td><a href="/Cpull/InquiryServlet" class="button">お問い合わせ</a></td>
			<td><a href="/Cpull/LoginServlet" class="button">ログアウト</a></td>
			</tr>
			</table>
		</div>
		</div>
	</main>
</body>
</html>

