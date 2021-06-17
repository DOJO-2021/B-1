<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>トークルーム詳細</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/talk_detail.css">
</head>
<body>
	<header>
	    <jsp:include page = "/WEB-INF/jsp/header.jsp"/>
	</header>

	<main>
	<div id="wrapper">
	<div class="talkdetail_box">
		<!-- トークルームの題名 -->
		<h1 class="room_name">地方出身者あつまれ！</h1>

		<!-- トークルームの詳細 -->
		<div class="room_detail">
			みなさんどこの出身ですか？<br> ご当地トーク楽しみましょう～！
		</div>
		<!-- トークルームの詳細 -->
		<a href="https://us04web.zoom.us/j/79570038670?pwd=RTI0b0NqWUZsS01GYTV6ODJhMkFSUT09" class="button1">入室</a>
		<!-- zoomのリンク先を貼る -->
		<a href="/Cpull/TalkroomServlet" class="button2">一覧へ戻る</a>
	</div>
	</div>
	</main>

</body>
</html>