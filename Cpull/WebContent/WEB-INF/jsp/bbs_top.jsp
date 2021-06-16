<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>掲示板トップ</title>
	<link rel="stylesheet" href="/Cpull/css/bbs_top.css">
	<jsp:include page = "/WEB-INF/jsp/header.jsp"/>
</head>
<body>
	<div class="wrapper">
		<main>
			<h1>掲示板トップ</h1>
			<form method="POST" action="/Cpull/BbsServlet">
				<input type="text" name="bbs_search" placeholder="検索したいワードを入力">
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
						<option value="others">その他</option>
					</select>
					</td>
					<td>
					<select name="kind">
						<option value="personal">パーソナルスキルコース</option>
						<option value="IT">IT基礎コース</option>
						<option value="Java">Java基礎コース</option>
						<option value="develope">開発演習</option>
						<option value="others">その他</option>
					</select>
					</td>
				</tr>
				</table>
			</form>
			<h2>掲示板のスレッド一覧を表示します</h2>
			<form method="POST" action="/Cpull/BbsListServlet">
				<input type="submit" name="list" value="一覧">
			</form>
			<h2>質問・悩みを投稿する</h2>
			<a href="/Cpull/BbsCreateServlet">新規作成</a>
		</main>
	</div>
</body>
</html>