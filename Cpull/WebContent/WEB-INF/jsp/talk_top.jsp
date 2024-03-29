<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>トークルーム</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/talk_top.css">
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
					<ul class="roomlist1">
					<li class="item">
						<dl>
							<dd><input type="submit" class="button" name="room" value="1"></dd>
							<dt class="word">雑談部屋</dt>
						</dl>
					</li>
					<li class="item">
						<dl>
							<dd><input type="submit" class="button" name="room" value="2"></dd>
							<dt class="word">お昼ご飯自慢</dt>
						</dl>
					</li>
					<li class="item">
						<dl>
							<dd><input type="submit" class="button" name="room" value="3"></dd>
							<dt class="word">地方出身者あつまれ！</dt>
						</dl>
					</li>
					</ul>
					<ul class="roomlist2">
					<li  class="item">
						<dl>
							<dd><input type="submit" class="button" name="room" value="4"></dd>
							<dt class="word">動物好きの方話しましょう</dt>
						</dl>
					</li>
					<li  class="item">
						<dl>
							<dd><input type="submit" class="button" name="room" value="5"></dd>
						    <dt class="word">バスケ好きな人！</dt>
						</dl>
					</li>
					<li  class="item">
						<dl>
							<dd><input type="submit" class="button" name="room" value="6"></dd>
							<dt class="word">野球好きな人</dt>
						</dl>
					</li>
					</ul>
				</form>
			</div>
		</div>

	</main>
<footer>
<br>
<br>
<br>
</footer>
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