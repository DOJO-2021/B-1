<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>自己紹介｜トップ</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/profile_top.css">
</head>
<body>
	<div class="wrapper">
		<header>
			<jsp:include page="/WEB-INF/jsp/header.jsp" />
		</header>

		<!-- メイン（ここから） -->

		<h1 class="top_name">自己紹介トップ</h1>
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
					<td><label>誕生日<br>
					<!-- プルダウンなし <select name="month">
						<option value="01">1月</option>
						<option value="02">2月</option>
						<option value="03">3月</option>
						<option value="04">4月</option>
						<option value="05">5月</option>
						<option value="06">6月</option>
						<option value="07">7月</option>
						<option value="08">8月</option>
						<option value="09">9月</option>
						<option value="10">10月</option>
						<option value="11">11月</option>
						<option value="12">12月</option>
					</select>
					<select name="date">
						<option value="01">1日</option>
						<option value="02">2日</option>
						<option value="03">3日</option>
						<option value="04">4日</option>
						<option value="05">5日</option>
						<option value="06">6日</option>
						<option value="07">7日</option>
						<option value="08">8日</option>
						<option value="09">9日</option>
						<option value="10">10日</option>
						<option value="11">11日</option>
						<option value="12">12日</option>
						<option value="13">13日</option>
						<option value="14">14日</option>
						<option value="15">15日</option>
						<option value="16">16日</option>
						<option value="17">17日</option>
						<option value="18">18日</option>
						<option value="19">19日</option>
						<option value="20">20日</option>
						<option value="21">21日</option>
						<option value="22">22日</option>
						<option value="23">23日</option>
						<option value="24">24日</option>
						<option value="25">25日</option>
						<option value="26">26日</option>
						<option value="27">27日</option>
						<option value="28">28日</option>
						<option value="29">29日</option>
						<option value="30">30日</option>
						<option value="31">31日</option>
						</select> -->
					<input type="date" name="USER_BIRTH" min="1940-01-01" max="2021-12-31">
					</label></td>
				</tr>
				<tr>
					<td><label>備考<br> <input type="text"
							name="USER_REMARKS">
					</label></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" id="search" name="serch" value="検索" class="button1">

				<div class="msg">登録者すべてのプロフィールを閲覧できます</div>
					 <a href="/Cpull/ProfileListServlet">
					 <input type="button" id="search" name="list" value="一覧" class="button2">
					 </a>
					</td>
				</tr>
			</table>
		</form>
		<!-- メイン（ここまで） -->
		<!-- フッター（ここから） -->

		<!-- フッター（ここまで） -->
	</div>
</body>
</html>