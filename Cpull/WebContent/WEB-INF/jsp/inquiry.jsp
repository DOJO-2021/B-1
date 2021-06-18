<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お問い合わせフォーム</title>
<link rel="stylesheet" href="/Cpull/css/common.css">
<link rel="stylesheet" href="/Cpull/css/inquiry.css">
</head>
<body>
	<div class="wrapper">
		<header>
			<jsp:include page="/WEB-INF/jsp/header.jsp" />
		</header>
		<main>
			<h1 class="top_name">お問い合わせフォーム</h1>
			<form method="POST" action="/Cpull/InquiryServlet"
				onSubmit="return check()">
				<!-- フォームの属性 method="POST action="内容送信の場所" -->
				<div class="box">
				<div>
					お問い合わせの件名<br> <input type="text" name="SUBJECT"
						placeholder="お問い合わせ">
				</div>
				<div>
					お問い合わせの内容<br>
					<textarea name="MESSAGE" placeholder="トークルームにこんな部屋が欲しい！など"></textarea>
				</div>
				<div>
					<input type="submit" name="submit" value="送信" class="button">
				</div>
				</div>
			</form>
		</main>
	</div>
	<script src="/Cpull/js/inquiry.js"></script>
</body>
</html>