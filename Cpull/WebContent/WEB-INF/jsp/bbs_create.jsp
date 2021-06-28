<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Draft"%>
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
<div class="wrapper">
	<header>
		<jsp:include page="/WEB-INF/jsp/header.jsp" />
	</header>
	<main>
		<!-- サブメニュー追加 -->
		<h1 class="top_name">スレッド新規作成</h1>
		<form method="POST" action="/Cpull/BbsCreateServlet">
			<!-- onSubmit="return check()" -->
			<div class="box">
				タイトル<br> <input type="text" name="bbs_title"
					value="${draftList.get(0).draft_title}" placeholder="スレッドタイトルを入力"><br>
				詳細<br> <input type="text" name="bbs_details"
					value="${draftList.get(0).draft_details}" placeholder="スレッドの内容を入力"><br>
				<!-- 				<table>
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
						</select></td> -->
				<!-- <td>
				<select name="bbs_category">
					<option value="10">パーソナルスキルコース</option>
					<option value="11">IT基礎コース</option>
					<option value="12">Java基礎コース</option>
					<option value="13">開発演習</option>
					<option value="14">その他</option>
				</select>
				</td>-->
<!-- 				</tr>
				</table> -->
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
					<label for="bbs_range">公開範囲</label> <select id="kind"
						name="bbs_range">
						<option value="0">すべての人</option>
						<option value="1">受講者のみ</option>
					</select>


					<div>
						パスワード<br> <input type="text" name="bbs_pw"
							value="${draftList.get(0).draft_pw}">
					</div><br>
					<div>
						<input id="save" type="submit" name="submit" value="下書き保存"
							class="button"> <input type="submit" name="submit"
							value="下書き読込" class="button"> <input id="push"
							type="submit" name="submit" value="新規投稿" class="button">
					</div>
				</div>
			</div>
		</form>
	</main>
	<footer>
		<br> <br> <br> <br> <br>
	</footer>
	<script src="/Cpull/js/bbs_create.js"></script>
	</div>
</body>
</html>