<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント登録完了</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/r_result.css">
</head>
<body>
	<div class="wrapper">
		<header>
			<h1 class="logo">
				<img src="images/Cpull_logo.png" alt="CpullLOGO" width="240"
					height="130">
			</h1>
		</header>
	</div>
  <main>
    <h1 class="top_name"><c:out value="${result.title}" /></h1>
    <div class="message"><a href="${result.backTo}"><c:out value="${result.message}"></c:out></a></div>
  </main>
<footer>
  <br> <br> <br> <br> <br> <br>
  <br> <br> <br> <br> <br> <br> <br>
  <br>
  <br>
  <br>
</footer>
</body>
</html>