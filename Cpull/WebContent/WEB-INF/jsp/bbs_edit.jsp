<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スレッド編集</title>
</head>
<body>
<h1>スレッド編集</h1>
<form  method="POST" action="/Cpull/BbsEditServlet">
タイトル<br>
	<input type="text" name="title" value="${e.title}">
内容<br>
	<input type="text" name="detail" value="${e.detail}">
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

<div>
	<label for="kind">公開範囲</label>
	<select id="kind" name="kind">
		<option value="everyone">すべての人</option>
		<option value="student">受講者のみ</option>
	</select>
</div>
<div>
	パスワード<br>
	<input type="text" name="pw">
</div>
<div>
	<input type="submit" name="submit" value="下書き保存">
	<input type="submit" name="submit" value="更新">
	<input type="submit" name="submit" value="削除">
</div>
</form>
</body>
</html>