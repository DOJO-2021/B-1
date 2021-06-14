<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>スレッド新規作成</title>
	<link rel="stylesheet" href="/Cpull/css/bbs_create.css">
</head>
<body>
	<header>
	<!-- 後からヘッダー追加 -->
	</header>

	<main>
		<!-- サブメニュー追加 -->
		<form method="POST" action="/Cpull/BbsCreateServlet">
			<input type="text" name="new_title" placeholder="スレッドタイトルを入力" id="new_title"><br>
			<input type="text" name="new_detail" placeholder="スレッドの内容を入力" id="new_detail"><br>
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
	</main>
</body>
</html>