<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/Cpull/css/bbs_top.css">
</head>
<body>
	<h1>掲示板トップ</h1>
	<form method="POST" action="/Cpull/BbsServlet">
		<input type="text" name="bbs_seach" placeholder="検索したいワードを入力">
		<input type="submit" name="submit" value="検索">
		<table>
		<tr>
			<th>悩み</th>
			<th>質問</th>
		</tr>
		<tr>
			<td>
			<select name="kind">
				<option value="personal">パーソナルスキルコース</option>
				<option value="IT">IT基礎コース</option>
				<option value="Java">Java基礎コース</option>
				<option value="develope">開発演習</option>
			</select>
			</td>
			<td>
			<select name="kind">
				<option value="personal">パーソナルスキルコース</option>
				<option value="IT">IT基礎コース</option>
				<option value="Java">Java基礎コース</option>
				<option value="develope">開発演習</option>
			</select>
			</td>
		</tr>
		</table>
	</form>
	<h2>掲示板の書き込み一覧を表示します</h2>
	<form method="POST" >

	</form>
</body>
</html>