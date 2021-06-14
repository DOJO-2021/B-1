<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スレッド編集</title>
</head>
<body>
<h1>スレッド編集</h1>
<form action="">
タイトル<br>
	<input type="text" name="title" value="${e.title}">
内容<br>
	<input type="text" name="detail" value="${e.detail}">
<div>
	<label for="kind">悩み</label>
	<select id="kind" name="kind">
		<option value="personal">パーソナル</option>
		<option value="it_basic">IT基礎</option>
		<option value="java_basic">Java基礎</option>
		<option value="development">開発演習</option>
		<option value="other">その他</option>
	</select>
</div>

<div>
	<label for="kind">質問</label>
	<select id="kind" name="kind">
		<option value="personal">パーソナル</option>
		<option value="it_basic">IT基礎</option>
		<option value="everyone">Java基礎</option>
		<option value="development">開発演習</option>
		<option value="other">その他</option>
	</select>
</div>

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