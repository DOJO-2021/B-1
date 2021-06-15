<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>トークルーム</title>
<link rel="stylesheet" href="/Cpull/css/style.css">
</head>
<body>
	<header>
		<!-- あとからヘッダーを入れる -->
	</header>

	<main>
		<h1 class="top_name">トークルームトップ</h1>

		<!-- wrapperでスクロールバーを作成する -->
		<div id="wrapper">
			<!-- トークルームの題名 -->
			<div class="talkroom_box">
			<form action="/Cpull/TalkroomDetailServlet" method = "post">
				<input type="submit"  class="talkroom"name="room" value="1">
				<p>雑談部屋</p>
				<input type="submit"  class="talkroom"name="room" value="2">
				<p>お昼ご飯自慢</p>
				<input type="submit"  class="talkroom"name="room" value="3">
				<p>地方出身者あつまれ！</p>
			</form>
				<input type="submit"  class="talkroom"name="room" value="4">
				<p>動物好きの方話しましょう</p>
				<input type="submit"  class="talkroom"name="room" value="5">
				<p>バスケ好きな人！</p>
				<input type="submit"  class="talkroom"name="room" value="6">
				<p>野球好きな人</p>

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