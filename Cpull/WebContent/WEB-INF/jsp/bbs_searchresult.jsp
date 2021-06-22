<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>スレッド検索結果</title>
	<link rel="stylesheet" href="/Cpull/css/bbs_searchresult.css">
	<link rel="stylesheet" href="/Cpull/css/bbs_common.css">
	<jsp:include page = "/WEB-INF/jsp/header.jsp"/>
	<jsp:include page = "/WEB-INF/jsp/submenu.jsp"/>
</head>
<body>
	<div class="wrapper">
		<main>
			<h1>検索結果</h1>
			<h3>カテゴリー検索</h3>
			<p><form method="POST" action="/Cpull/BbsCategoryServlet">
			選択されたカテゴリーのスレッドを表示します<br>
			カテゴリーの種類を選んでください：
			<label for="worry">
 			<input type="radio" id="worry" name="Pass" onclick="ShowHideDiv()" />
 			悩み
			</label>
			<label for="question">
			 <input type="radio" id="question" name="Pass" onclick="ShowHideDiv()" />
			 質問
			</label>
			<div id="worryPass" style="display: none">
				カテゴリを選択してください：
				<select name="kind1">
					<option value="0">パーソナルスキルコース</option>
					<option value="1">IT基礎コース</option>
					<option value="2">Java基礎コース</option>
					<option value="3">開発演習</option>
					<option value="4">その他</option>
				 </select><br>
				 <input type="submit" name="submit" value="悩みで検索">
			</div>
			<div id="questionPass" style="display: none">
				カテゴリを選択してください：
				<select name="kind2">
					<option value="10">パーソナルスキルコース</option>
					<option value="11">IT基礎コース</option>
					<option value="12">Java基礎コース</option>
					<option value="13">開発演習</option>
					<option value="14">その他</option>
				</select><br>
				<input type="submit" name="submit" value="質問で検索">
			</div>
			<script src="/Cpull/js/bbs_category.js"></script>
			</form></p>
			<p>${bbsList.size()}件ヒットしました！</p>
			<c:forEach var="e" items="${bbsList}">
				<form method="POST" action="/Cpull/BbsDetailServlet">
				<input hidden name="bbs_id" value="${e.bbs_id}">
				${e.bbs_title}<br>
				<input type="submit" name="detail" value="詳細ページへ">
				</form>
				<form method="GET" action="/Cpull/BbsEditServlet">
				<input type="submit" name="edit" value="編集ページへ">
				</form>
				<hr>
			</c:forEach>
		</main>
	</div>
</body>
</html>