<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お問い合わせフォーム</title>
</head>
<body>
	<header> </header>
	<main>
		<p>お問い合わせフォーム</p>
		<form method="POST" action="/Cpull/InquiryServlet"><!-- フォームの属性 method="POST action="内容送信の場所" -->
			<div>
				お問い合わせの件名<br> <input type="text" name="SUBJECT"
					placeholder="お問い合わせ">
			</div>
			<div>
				お問い合わせの内容<br>
				<textarea name="MESSAGE" placeholder="トークルームにこんな部屋が欲しい！など"></textarea>
			</div>
			<div>
				<input type="submit" name="submit" value="送信" onClick="linkCheck(1)">
			</div>
		</form>
	</main>


</body>
</html>