<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お問い合わせ内容リスト</title>
<link rel="stylesheet" href="/Cpull/css/common.css">
<link rel="stylesheet" href="/Cpull/css/i_list.css">
</head>
<body>
	<div class="wrapper">
		<header>
			<jsp:include page="/WEB-INF/jsp/header.jsp" />
		</header>
		<main>
			<h1 class="top_name">お問い合わせ入力内容</h1>
			<!-- ID<input type="text" name="USER_ID" value="${Inquiry.user_id}"><br> -->

			<table class="list">

				<tr>
					<th>ユーザーID</th>
					<th><input type="text" name="USER_ID" value="dojohanako@seplus2021.onmicrosoft.com"></th>
				</tr>
				<tr>
					<th>お問い合わせID</th>
					<th><input type="text" name="INQUIRY_ID" value="1"></th>
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
			<hr>
						<table class="list">
				<tr>
					<th>ユーザーID</th>
					<th><input type="text" name="USER_ID" value="dojohanako@seplus2021.onmicrosoft.com"></th>
				</tr>
				<tr>
					<th>お問い合わせID</th>
					<th><input type="text" name="INQUIRY_ID" value="2"></th>
				</tr>
				<tr>
					<th>件名</th>
					<th><input type="text" name="SUBJECT" value="ログアウトについて"></th>
				</tr>
				<tr>
					<th>内容</th>
					<th><input type="text" name="MESSAGE"
						value="ログアウトできません！"></th>
				</tr>
				<tr>
					<th>お問い合わせ時刻</th>
					<th><input type="text" name="TS"
						value="2021-06-18 11:39:26.752841"></th>
				</tr>

			</table>

			<hr>


		</main>
	</div>

</body>
</html>