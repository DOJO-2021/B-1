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
タイトル<br>
	<input type="text" name="title" value="${e.title}">
内容<br>
	<input type="text" name="detail" value="${e.detail}">
コメント欄<br>
	<input type="text" name="comment_list" value="${e.comment_list}">

<div>
<form action="">
コメント<br>
	<textarea name="message"></textarea>
	<input type="submit" name="submit" value="回答">
	匿名にする？<br>
	<input type="checkbox" name="how" value="name">
</form>
</div>
</body>
</html>