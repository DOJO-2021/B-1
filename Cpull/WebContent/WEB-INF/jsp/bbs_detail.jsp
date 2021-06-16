<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>掲示板詳細</title>
<link rel="stylesheet" href="/Cpull/css/bbs_detail.css">
<link rel="stylesheet" href="/Cpull/css/common.css">
<link rel="stylesheet" href="/Cpull/css/bbs_common.css">
</head>
<body>
<header>
    <jsp:include page = "/WEB-INF/jsp/header.jsp"/>
 </header>

<h1>掲示板詳細</h1>

タイトル<br>
	<input type="text" name="title" value="${Reply.bbs_title}">
内容<br>
	<input type="text" name="detail" value="${Reply.bbs_detail}">

コメント欄<br>
	<input type="text" name="comment_list" value="${Reply.comment_list}">


<div>
<form action="" method="POST">
コメント<br>
	<textarea name="message"></textarea>
	<input type="submit" name="submit" value="回答">
	匿名にする？<br>
	<input type="checkbox" name="how" value="name">
</form>
</div>
</body>
</html>