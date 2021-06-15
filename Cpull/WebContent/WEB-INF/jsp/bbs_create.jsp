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
			<input type="text" name="bbs_title" placeholder="スレッドタイトルを入力" id="new_title"><br>
			<input type="text" name="bbs_details" placeholder="スレッドの内容を入力" id="new_detail"><br>
			<table>
			<tr>
				<th>悩み</th>
				<th>質問</th>
			</tr>
			<tr>
				<td>
				<select name="bbs_category">
					<option value="0">パーソナルスキルコース</option>
					<option value="1">IT基礎コース</option>
					<option value="2">Java基礎コース</option>
					<option value="3">開発演習</option>
					<option value="4">その他</option>
				</select>
				</td>
				<td>
				<select name="bbs_category">
					<option value="0">パーソナルスキルコース</option>
					<option value="1">IT基礎コース</option>
					<option value="2">Java基礎コース</option>
					<option value="3">開発演習</option>
					<option value="4">その他</option>
				</select>
				</td>
			</tr>
			</table>
	<div>
		<label for="bbs_range">公開範囲</label>
			<select id="kind" name="kind">
				<option value="0">すべての人</option>
				<option value="1">受講者のみ</option>
			</select>
	</div>

<div>
	パスワード<br>
	<input type="text" name="bbs_pw">
</div>
<div>
	<input type="submit" name="submit"  value="下書き">
	<input type="submit" name="submit" value="作成">
</div>

		</form>
	</main>
</body>
</html>