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
	    <jsp:include page = "/WEB-INF/jsp/header.jsp"/>
		<!-- あとからヘッダーを入れる -->
	</header>

	<main>
		<h1 class="top_name">メニュー</h1>
		<div class="menu_box">
			<a href="/Cpull/ProfileServlet">自己紹介</a> <a
				href="/Cpull/TalkroomServlet">トークルーム</a> <a href="/Cpull/BbsServlet">掲示板</a>
			<a href="/Cpull/MypageServlet">マイページ</a> <a
				href="/Cpull/InquiryServlet">お問い合わせ</a> <a
				href="/Cpull/LoginServlet">ログアウト</a>
		</div>
	</main>
</body>
</html>

