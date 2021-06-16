<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>トークルーム</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="/css/talk_top.css">
</head>
<body>
	<header>
	    <jsp:include page = "/WEB-INF/jsp/header.jsp"/>
	</header>


	<main>
		<h1 class="top_name">トークルームトップ</h1>

		<!-- wrapperでスクロールバーを作成する -->
		<div id="wrapper">
			<!-- トークルームの題名 -->
			<div class="talkroom_box">
				<form action="/Cpull/TalkroomDetailServlet" method="post">
					<table>
						<tr>
							<td><input type="submit" class="talkroom" name="room"
								value="1"></td>
							<td><p>雑談部屋</p></td>
							<td><input type="submit" class="talkroom" name="room"
								value="2"></td>
							<td><p>お昼ご飯自慢</p></td>
						</tr>
						<tr>
							<td><input type="submit" class="talkroom" name="room"
								value="3"></td>
							<td><p>地方出身者あつまれ！</p></td>
							<td><input type="submit" class="talkroom" name="room"
								value="4"></td>
							<td><p>動物好きの方話しましょう</p></td>
						<tr>
							<td><input type="submit" class="talkroom" name="room"
								value="5"></td>
							<td><p>バスケ好きな人！</p></td>
							<td><input type="submit" class="talkroom" name="room"
								value="6"></td>
							<td><p>野球好きな人</p></td>
						</tr>
					</table>
				</form>
			</div>
		</div>

	</main>

</body>
</html>


<!-- wrapperのところでスクロールバーをつけるCSS
#wrapper {
	height: px;
	width: px;
	overflow-y: scroll;
	margin-top: px;
	margin-left: px;
	text-align: ;
}
-->