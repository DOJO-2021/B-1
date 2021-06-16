<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>自己紹介｜トップ</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="wrapper">
		<header>
			<jsp:include page="/WEB-INF/jsp/header.jsp" />
		</header>
		<!-- メイン（ここから） -->
		<h1>自己紹介トップ</h1>
		<form method="POST" action="/Cpull/ProfileServlet">
			<table>
				<tr>
					<td><label>氏名<br> <input type="text"
							name="USER_NAME">
					</label></td>
					<td><label>会社名<br> <input type="text"
							name="USER_COMPANY">
					</label></td>
					<td>
				</tr>
				<tr>
					<td><label>出身<br> <input type="text"
							name="USER_PREFECTURE">
					</label></td>
					<td><label>趣味<br> <input type="text"
							name="USER_HOBBY">
					</label></td>
				</tr>
				<tr>
					<td><label>特技<br> <input type="text"
							name="USER_SKILL">
					</label></td>
					<td><label>誕生日<br> <input type="date"
							name="USER_BIRTH" min="1900-01-01" max="2021-12-31">
					</label></td>
				</tr>
				<tr>
					<td><label>備考<br> <input type="text"
							name="USER_REMARKS">
					</label></td>
				</tr>
			</table>
					<input type="submit" id="search" name="serch" value="検索">
		</form>
					 <input type="submit" id="search" name="list" value="一覧">

		<!-- メイン（ここまで） -->
		<!-- フッター（ここから） -->

		<!-- フッター（ここまで） -->
	</div>
</body>
</html>