<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/bbs_common.css">
</head>
<body>
<div class="wrapper">
<!-- サブメニュー　6-17行目を掲示板の各ページのヘッダー下にコピーする -->
<header>
<nav class="submenu">
	<ul>
		<li><a href="/Cpull/BbsListServlet">一覧</a></li>
		<li><a href="/Cpull/BbsCreateServlet">新規作成</a></li>
		<li>
			<form method="POST" action="/Cpull/BbsServlet">
				<input type="text" name="bbs_search" placeholder="検索したいワードを入力">
				<input type="submit" name="submit" value="検索" class="submenu_button">
			</form>
		</li>
	</ul>
</nav>
  </header>
  </div>
  </body>
</html>