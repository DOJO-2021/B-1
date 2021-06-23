<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>全てのプロフィール一覧</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/profile_list.css">
</head>
<body>
	<div class="wrapper">

		<header>
			<jsp:include page="/WEB-INF/jsp/header.jsp" />
		</header>


		<!-- メイン（ここから） -->
		<h1 class="top_name">自己紹介一覧</h1>
		<br>
		<div class="msg">${cardList.size()}件ヒットしました！</div>

		並び替える:
		<input type="radio" name="PS" onclick="sort(0)" checked="checked" id="psr">
		<label for="psr">登録順</label>
		<input type="radio" name="PS" onclick="sort(1)" id="psn">
		<label for="psn">五十音順</label>
		<input type="radio" name="PS" onclick="sort(2)" id="psb">
		<label for="psb">生年月日順</label>
		<hr>

		<div class="list_box" id="prof_regist">
			<c:forEach var="e" items="${cardList}">
				<form method="POST" action="/Cpull/ProfileServlet.java">

					<!-- 画像保留 -->
					<table>
						<tr>
							<td>氏名<br> <input type="text" name="USER_NAME"
								value="${e.user_name}">
							</td>
							<td>よみかた<br> <input type="text" name="USER_K_NAME"
								value="${e.user_k_name}">
							</td>
						</tr>
						<tr>
							<td>会社名<br> <input type="text" name="USER_COMPANY"
								value="${e.user_company}">
							</td>
							<td>出身<br> <input type="text" name="USER_PREFECTURE"
								value="${e.user_prefecture}">
							</td>
						</tr>
						<tr>
							<td>趣味<br> <input type="text" name="USER_HOBBY"
								value="${e.user_hobby}">
							</td>
							<td>特技<br> <input type="text" name="USER_SKILL"
								value="${e.user_skill}">
							</td>
						</tr>
						<tr>
							<td>誕生日<br> <input type="text" name="USER_BIRTH"
								value="${e.user_birth}">
							</td>
							<td>備考<br> <input type="text" name="USER_REMARKS"
								value="${e.user_remarks}">
							</td>
						</tr>
					</table>
					<hr>
					<!-- 線のスタイル変えるのアリ（点線とか！） -->
				</form>
			</c:forEach>
		</div>

		<div class="list_box" id="prof_name" style="display: none">
			<c:forEach var="e" items="${cardList_name}">
				<form method="POST" action="/Cpull/ProfileServlet.java">

					<!-- 画像保留 -->
					<table>
						<tr>
							<td>氏名<br> <input type="text" name="USER_NAME"
								value="${e.user_name}">
							</td>
							<td>よみかた<br> <input type="text" name="USER_K_NAME"
								value="${e.user_k_name}">
							</td>
						</tr>
						<tr>
							<td>会社名<br> <input type="text" name="USER_COMPANY"
								value="${e.user_company}">
							</td>
							<td>出身<br> <input type="text" name="USER_PREFECTURE"
								value="${e.user_prefecture}">
							</td>
						</tr>
						<tr>
							<td>趣味<br> <input type="text" name="USER_HOBBY"
								value="${e.user_hobby}">
							</td>
							<td>特技<br> <input type="text" name="USER_SKILL"
								value="${e.user_skill}">
							</td>
						</tr>
						<tr>
							<td>誕生日<br> <input type="text" name="USER_BIRTH"
								value="${e.user_birth}">
							</td>
							<td>備考<br> <input type="text" name="USER_REMARKS"
								value="${e.user_remarks}">
							</td>
						</tr>
					</table>
					<hr>
					<!-- 線のスタイル変えるのアリ（点線とか！） -->
				</form>
			</c:forEach>
		</div>

		<div class="list_box" id="prof_birthday" style="display: none">
			<c:forEach var="e" items="${cardList_birthday}">
				<form method="POST" action="/Cpull/ProfileServlet.java">

					<!-- 画像保留 -->
					<table>
						<tr>
							<td>氏名<br> <input type="text" name="USER_NAME"
								value="${e.user_name}">
							</td>
							<td>よみかた<br> <input type="text" name="USER_K_NAME"
								value="${e.user_k_name}">
							</td>
						</tr>
						<tr>
							<td>会社名<br> <input type="text" name="USER_COMPANY"
								value="${e.user_company}">
							</td>
							<td>出身<br> <input type="text" name="USER_PREFECTURE"
								value="${e.user_prefecture}">
							</td>
						</tr>
						<tr>
							<td>趣味<br> <input type="text" name="USER_HOBBY"
								value="${e.user_hobby}">
							</td>
							<td>特技<br> <input type="text" name="USER_SKILL"
								value="${e.user_skill}">
							</td>
						</tr>
						<tr>
							<td>誕生日<br> <input type="text" name="USER_BIRTH"
								value="${e.user_birth}">
							</td>
							<td>備考<br> <input type="text" name="USER_REMARKS"
								value="${e.user_remarks}">
							</td>
						</tr>
					</table>
					<hr>
					<!-- 線のスタイル変えるのアリ（点線とか！） -->
				</form>
			</c:forEach>
		</div>
	</div>
	<script src="/Cpull/js/profile_search.js"></script>
<footer>
  <br> <br> <br> <br> <br> <br>
  <br> <br> <br> <br> <br> <br>
</footer>
</body>
</html>