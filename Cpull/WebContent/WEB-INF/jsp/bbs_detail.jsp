<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>掲示板詳細</title>
</head>
<body>
<h1>掲示板詳細</h1>
<h2>タイトル</h2>
	<input type="text" name="title" value="${e.title}">
<h2>内容</h2>
	<input type="text" name="detail" value="${e.detail}">
<h2>コメント欄</h2>
	<input type="text" name="comment_list" value="${e.comment_list}">
<div>
<h2>コメント</h2>
	<textarea name="message"></textarea>
	<input type="submit" name="submit" value="回答">
	匿名にする？<br>
	<input type="checkbox" name="how" value="name">
</div>
</body>
</html>