<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="model.Draft" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スレッド新規作成</title>
<link rel="stylesheet" href="/Cpull/css/bbs_create.css">
<link rel="stylesheet" href="/Cpull/css/common.css">
<link rel="stylesheet" href="/Cpull/css/bbs_common.css">
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/header.jsp" />
	</header>
	<main>
		<!-- サブメニュー追加 -->
		<h1>スレッド新規作成</h1>
		<form method="POST" action="/Cpull/BbsCreateServlet">
			タイトル<br> <input type="text" name="bbs_title"
				value="${draftList.get(0).draft_title}" placeholder="スレッドタイトルを入力"><br>
			詳細<br> <input type="text" name="bbs_details"
				value="${draftList.get(0).draft_details}" placeholder="スレッドの内容を入力"><br>
			<table>
				<tr>
					<th>悩み</th>
					<th>質問</th>
				</tr>
				<tr>
					<td><select name="bbs_category">
							<option value="00">パーソナルスキルコース</option>
							<option value="01">IT基礎コース</option>
							<option value="02">Java基礎コース</option>
							<option value="03">開発演習</option>
							<option value="04">その他</option>
					</select></td>
					<!-- <td>
				<select name="bbs_category">
					<option value="10">パーソナルスキルコース</option>
					<option value="11">IT基礎コース</option>
					<option value="12">Java基礎コース</option>
					<option value="13">開発演習</option>
					<option value="14">その他</option>
				</select>
				</td>-->
				</tr>
			</table>
			<div>
				<label for="bbs_range">公開範囲</label>
				<select id="kind"	name="bbs_range" >
					<option value="0">すべての人</option>
					<option value="1">受講者のみ</option>
				</select>
			</div>

			<div>
				パスワード<br> <input type="text" name="bbs_pw"
					value="${draftList.get(0).draft_pw}">
			</div>
			<div>
				<input type="submit" name="submit" value="draft_save"> <input
					type="submit" name="submit" value="draft_load"> <input
					type="submit" name="submit" value="bbs_create">
			</div>

		</form>
	</main>
</body>
</html>