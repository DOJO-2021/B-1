<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>掲示板トップ</title>
	<link rel="stylesheet" href="/Cpull/css/bbs_top.css">
	<link rel="stylesheet" href="/Cpull/css/bbs_common.css">
	<jsp:include page = "/WEB-INF/jsp/header.jsp"/>
</head>
<body>
	<div class="wrapper">

		<main>
			<h1 class="top_name1">掲示板トップ</h1>
			<div class="box">
			<h2 class="top_name2">キーワード・カテゴリーでスレッドを検索します</h2>
			<h3 class="top_name3">キーワード検索</h3>
			入力されたキーワードをタイトルに含むスレッドを表示します
			<form method="POST" action="/Cpull/BbsServlet">
				<input type="text" name="bbs_search" placeholder="検索したいワードを入力">
				<input type="submit" name="submit" value="検索" class="search_button"><br>
			</form>
			<h3 class="top_name3">カテゴリー検索</h3>
			<form method="POST" action="/Cpull/BbsCategoryServlet">
				選択されたカテゴリーのスレッドを表示します<br>
				<span>カテゴリーの種類を選んでください：</span>
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
					 <input type="submit" name="submit" value="悩みで検索" class="troublesearch_button">
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
					<input type="submit" name="submit" value="質問で検索" class="guestionsearch_button">
				</div>
				<script src="/Cpull/js/bbs_category.js"></script>
			</form>
			<h2 class="top_name2">掲示板のスレッド一覧を表示します</h2>
			<form method="POST" action="/Cpull/BbsListServlet">
				<input type="submit" name="list" value="一覧" class="list_button">
			</form>
			<h2 class="top_name2">質問・悩みを投稿する</h2>
				<a href="/Cpull/BbsCreateServlet" class="button">スレッド新規作成</a>
		</div>
		</main>
	</div>

</body>
</html>