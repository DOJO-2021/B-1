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
				<a href="/jsp/talk_detail.jsp">雑談部屋</a>
				<a href="aaa.jsp">お昼ご飯自慢</a>
				<a href="bbb.jsp">地方出身者あつまれ！</a>
				<a href="ccc.jsp">関東勢あつまれ</a>
				<a href="ddd.jsp">動物好きあつまれ</a>
				<a href="eee.jsp">男子集合！</a>
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