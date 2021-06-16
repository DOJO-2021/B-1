<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!-- サブメニュー　6-17行目を掲示板の各ページのヘッダー下にコピーする -->
<nav>
	<ul>
		<li><a href="/Cpull/BbsListServlet">一覧</a></li>
		<li><a href="/Cpull/BbsCreateServlet">新規作成</a></li>
		<li>
			<form method="POST" action="/Cpull/BbsServlet">
				<input type="text" name="bbs_search" placeholder="検索したいワードを入力">
				<input type="submit" name="submit" value="検索">
			</form>
		</li>
	</ul>
</nav>