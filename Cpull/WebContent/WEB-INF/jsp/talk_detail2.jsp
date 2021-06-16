<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>トークルーム詳細</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/talk_detail2.css">
</head>
<body>
	<header>
	    <jsp:include page = "/WEB-INF/jsp/header.jsp"/>
		<!-- あとからヘッダーを入れる -->
	</header>

	<main>
		<!-- トークルームの題名 -->
		<h1 class="room_name">お昼ご飯自慢</h1>

		<!-- トークルームの詳細 -->
		<div class="room_detail">
			みなさんの今日の昼食は何ですか？<br> みんなでわいわいお昼ご飯を食べましょう～！
		</div>
		<!-- トークルームの詳細 -->
		<a
			href="https://us04web.zoom.us/j/78449923830?pwd=TWRFVFJKdUNUa01GQ3puWENQZzlsdz09">入室</a>
		<!-- zoomのリンク先を貼る -->
		<a href="/Cpull/TalkroomServlet">一覧へ戻る</a>
	</main>

</body>
</html>