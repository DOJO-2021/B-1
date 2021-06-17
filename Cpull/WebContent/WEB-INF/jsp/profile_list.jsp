<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>全てのプロフィール一覧</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="wrapper">

		<header>
			<jsp:include page="/WEB-INF/jsp/header.jsp" />
		</header>


		<!-- メイン（ここから） -->
		<h1>自己紹介一覧</h1>
		<br>
			${cardList.size()}件ヒットしました！
		<hr>

		<c:forEach var="e" items="${cardList}">
			<form method="POST" action="/Cpull/ProfileServlet.java">

				<!-- 画像保留 -->

				名前<input type="text" name="USER_NAME" value="${e.user_name}"><br>
				よみかた<input type="text" name="USER_K_NAME" value="${e.user_k_name}"><br>
				会社名<input type="text" name="USER_COMPANY" value="${e.user_company}"><br>
				出身<input type="text" name="USER_PREFECTURE" value="${e.user_prefecture}"><br>
				趣味<input type="text" name="USER_HOBBY" value="${e.user_hobby}"><br>
				特技<input type="text" name="USER_SKILL" value="${e.user_skill}"><br>
				誕生日<input type="text" name="USER_BIRTH" value="${e.user_birth}"><br>
				備考<input type="text" name="USER_REMARKS" value="${e.user_remarks}"><br>
				<hr><!-- 線のスタイル変えるのアリ（点線とか！） -->

			</form>

		</c:forEach>


	</div>
</body>
</html>