<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スレッド編集</title>
<link rel="stylesheet" href="/Cpull/css/bbs_edit.css">
<link rel="stylesheet" href="/Cpull/css/common.css">
<link rel="stylesheet" href="/Cpull/css/bbs_common.css">
</head>
<body>
<div class="wrapper">
<!-- ヘッダー追加 -->
<header>
    <jsp:include page = "/WEB-INF/jsp/header.jsp"/>
</header>
<h1 class="top_name">スレッド編集</h1>
<c:forEach var="e" items="${bbsList}" >

<form  method="POST" action="/Cpull/BbsEditServlet2">
	<input type="hidden"name="bbs_id" value="${e.bbs_id}">
<div class="box">
	<h2 class="top_name2">タイトル</h2>
		<input type="text" name="bbs_title" value="${e.bbs_title}"><br>
	<h2 class="top_name2">内容</h2>
		<input type="text" name="bbs_details" value="${e.bbs_details}"><br>
		<!-- 	<table>
			<tr>
				<th>悩み</th>
				<th>質問</th>
			</tr>
						<tr>
				<td>
				<select name="bbs_category" >
					<option value="00">パーソナルスキルコース</option>
					<option value="01">IT基礎コース</option>
					<option value="02">Java基礎コース</option>
					<option value="03">開発演習</option>
					<option value="04">その他</option>
				</select>
				</td>
				<td>
				<select name="bbs_category">
					<option value="10">パーソナルスキルコース</option>
					<option value="11">IT基礎コース</option>
					<option value="12">Java基礎コース</option>
					<option value="13">開発演習</option>
					<option value="14">その他</option>
				</select>
				</td>
			</tr>
			</table>-->
				<div>

					カテゴリーの種類を選んでください：
					<label for="worry"><input type="radio" id="worry" name="Pass" onclick="ShowHideDiv()" />悩み</label>
					<label for="question"> <input type="radio" id="question" name="Pass" onclick="ShowHideDiv()" /> 質問</label>
					<br>
					<div id="worryPass" style="display: none">
						カテゴリを選択してください： <select name="kind1">
							<option value="1">パーソナルスキルコース</option>
							<option value="2">IT基礎コース</option>
							<option value="3">Java基礎コース</option>
							<option value="4">開発演習</option>
							<option value="5">その他</option>
						</select><br>
					</div>
					<div id="questionPass" style="display: none">
						カテゴリを選択してください： <select name="kind2">
							<option value="10">パーソナルスキルコース</option>
							<option value="11">IT基礎コース</option>
							<option value="12">Java基礎コース</option>
							<option value="13">開発演習</option>
							<option value="14">その他</option>
						</select><br>
					</div>

		<div>
			<label for="bbs_range">公開範囲</label>
			<select id="kind" name="bbs_range">
				<option value="0">すべての人</option>
				<option value="1">受講者のみ</option>
			</select>
		</div>
		<div>
		<h2 class="top_name2">パスワード</h2>
			<input type="text" name="bbs_pw" value="${e.bbs_pw}">
		</div><br>

		<div>
			<input type="submit" name="submit" value="更新" class="button">
			<input type="submit" name="submit" value="削除" class="button">
		</div>
		</div>
</div>
</form>

</c:forEach>
	<script src="/Cpull/js/bbs_create.js"></script>
</div>
</body>
<footer>
	<br> <br> <br> <br> <br>
</footer>
</html>