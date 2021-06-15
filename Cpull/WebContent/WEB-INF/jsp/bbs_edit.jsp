<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スレッド編集</title>
<link rel="stylesheet" href="/Cpull/css/bbs_create.css">
</head>
<body>
<h1>スレッド編集</h1>
<form  method="POST" action="/Cpull/BbsEditServlet">

タイトル<br>
	<input type="text" name="title" value="${bbs.title}">
内容<br>
	<input type="text" name="detail" value="${bbs.detail}">

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
	<select id="kind" name="bbs_range">
		<option value="0">すべての人</option>
		<option value="1">受講者のみ</option>
	</select>
</div>
<div>
	パスワード<br>
	<input type="text" name="bbs_pw">
</div>



<div>
	<input type="submit" name="submit" value="下書き保存">
	<input type="submit" name="submit" value="更新">
	<input type="submit" name="submit" value="削除">
</div>
</form>
</body>
</html>