<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お問い合わせ内容リスト</title>
</head>
<body>
	<header> </header>
	<main>
		<p>お問い合わせ入力内容</p>
			<form method="GET" action="/Cpull/IuquiryServlet">
			<!-- ID<input type="text" name="USER_ID" value="${Inquiry.user_id}"><br> -->
			お問い合わせID<input type="text" name="Inquiry_id" value="3"><br>
			件名<input type="text" name="SUBJECT" value="トークルームについて"><br>
			内容<input type="text" name="MESSAGE" value="雑談部屋をもう１部屋追加してほしいです"><br>
			お問い合わせ時刻<input type="text" name="TS" value="2021-06-15 11:49:03.339862"><br>
			</form>
	</main>
</body>
</html>