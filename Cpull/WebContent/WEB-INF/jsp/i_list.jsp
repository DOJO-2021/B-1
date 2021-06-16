<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お問い合わせ内容リスト</title>
<link rel="stylesheet" href="/Cpull/css/common.css">
</head>
<body>
	<header> </header>
	<main>
		<p>お問い合わせ入力内容</p>
		<!-- ID<input type="text" name="USER_ID" value="${Inquiry.user_id}"><br> -->
		<table>
			<tr>
				<th>お問い合わせID</th>
				<th><input type="text" name="Inquiry_id" value="3"></th>
			</tr>
			<tr>
				<th>件名</th>
				<th><input type="text" name="SUBJECT" value="トークルームについて"></th>
			</tr>
			<tr>
				<th>内容</th>
				<th><input type="text" name="MESSAGE"
					value="雑談部屋をもう１部屋追加してほしいです"></th>
			</tr>
			<tr>
				<th>お問い合わせ時刻</th>
				<th><input type="text" name="TS"
					value="2021-06-15 11:49:03.339862"></th>
			</tr>
		</table>
	</main>
</body>
</html>