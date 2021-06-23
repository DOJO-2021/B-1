<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スレッド編集</title>
<link rel="stylesheet" href="/Cpull/css/bbs_edit.css">
<link rel="stylesheet" href="/Cpull/css/common.css">
<link rel="stylesheet" href="/Cpull/css/bbs_common.css">
</head>
<body>
<!-- ヘッダー追加 -->
<header>
    <jsp:include page = "/WEB-INF/jsp/header.jsp"/>
</header>
<h1>スレッド編集</h1>
<c:forEach var="e" items="${bbsList}" >
<form  method="POST" action="/Cpull/BbsEditServlet2">
	<input type="hidden"name="bbs_id" value="${e.bbs_id}">
	タイトル<br>
		<input type="text" name="title" value="${e.bbs_title}"><br>
	内容<br>
		<input type="text" name="detail" value="${e.bbs_details}"><br>
			<table>
			<tr>
				<th>悩み</th>
				<th>質問</th>
			</tr>
						<tr>
				<td>
				<select name="bbs_category" >
					<option value="00">パーソナルスキルコース</option>
					<option value="01">IT基礎コース</option>
					<option value="02">Java基礎コース</option>
					<option value="03">開発演習</option>
					<option value="04">その他</option>
				</select>
				</td>
				<!-- <td>
				<select name="bbs_category">
					<option value="10">パーソナルスキルコース</option>
					<option value="11">IT基礎コース</option>
					<option value="12">Java基礎コース</option>
					<option value="13">開発演習</option>
					<option value="14">その他</option>
				</select>
				</td>-->
			</tr>
			</table>

		<div>
			<label for="bbs_range">公開範囲</label>
			<select id="kind" name="bbs_range">
				<option value="0">すべての人</option>
				<option value="1">受講者のみ</option>
			</select>
		</div>
		<div>
		パスワード<br>
			<input type="text" name="bbs_pw" value="${e.bbs_pw}">
		</div>
		<div>
			<input type="submit" name="submit" value="更新">
			<input type="submit" name="submit" value="削除">
		</div>
</form>
</c:forEach>
	<a href="/Cpull/BbsDraftSerlvet"><input type="submit" name="submit" value="下書き保存"></a>
</body>
</html>