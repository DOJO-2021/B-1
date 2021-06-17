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
			<h2>キーワード・カテゴリーでスレッドを検索します</h2>
			<h3>キーワード検索</h3>
			入力されたキーワードをタイトルに含むスレッドを表示します
			<form method="POST" action="/Cpull/BbsServlet">
				<input type="text" name="bbs_search" placeholder="検索したいワードを入力">
				<input type="submit" name="submit" value="検索"><br>
			</form>
			<h3>カテゴリー検索</h3>
			<form method="POST" action="/Cpull/BbsCategoryServlet">
				選択されたカテゴリーのスレッドを表示します<br>
				<span>カテゴリーの種類を選んでください</span>
				<label for="chkYes">
 				<input type="radio" id="chkYes" name="chkPassPort" onclick="ShowHideDiv()" />
 				悩み
				</label>
				<label for="chkNo">
				 <input type="radio" id="chkNo" name="chkPassPort" onclick="ShowHideDiv()" />
				 質問
				</label>
				<div id="dvPassport" style="display: none">
				 カテゴリを選択してください：
				 <select name="kind">
				 	<option value="0">パーソナルスキルコース</option>
					<option value="1">IT基礎コース</option>
					<option value="2">Java基礎コース</option>
					<option value="3">開発演習</option>
					<option value="4">その他</option>
				 </select>
				</div>
				<script src="/Cpull/js/bbs_category.js"></script>

				<!-- <table>
				<tr>
					<th>悩み</th>
					<th>質問</th>
				</tr>
				<tr>
					<td>
					<select name="kind1">
						<option value="0">パーソナルスキルコース</option>
						<option value="1">IT基礎コース</option>
						<option value="2">Java基礎コース</option>
						<option value="3">開発演習</option>
						<option value="4">その他</option>
					</select>
					</td>
					<td>
					<select name="kind2">
						<option value="10">パーソナルスキルコース</option>
						<option value="11">IT基礎コース</option>
						<option value="12">Java基礎コース</option>
						<option value="13">開発演習</option>
						<option value="14">その他</option>
					</select>
					</td>
				</tr>
				</table>-->
				<input type="submit" name="submit" value="検索">
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