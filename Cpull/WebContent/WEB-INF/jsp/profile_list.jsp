<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>自己紹介｜一覧検索結果</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="wrapper">
  <!-- ヘッダー（ここから） -->
  <header class="header">
    <h1 class="logo">
      <a href="list.html"><img src="images/logo.png" alt="名刺管理" width="240" height="100"></a>
    </h1>
  <ul id="nav">
      <li><a href="/simpleBC/MenuServlet">トップ</a></li>
      <li><a href="/simpleBC/SearchServlet">検索</a></li>
      <li><a href="/simpleBC/RegistServlet">登録</a></li>
      <li><a href="/simpleBC/LoginServlet">ログアウト</a></li>
  </ul>
  </header>
  <!-- ヘッダー（ここまで） -->
  <!-- メイン（ここから） -->
<h2>検索結果（更新／削除）</h2>
<hr>

<c:forEach var="e" items="${cardList}" >
	<form method="POST" action="/simpleBC/UpdateDeleteServlet">
	ID<input type="text" name="BUSINESSCARD_ID" value="${e.businesscard_id}"><br>
	会社名<input type="text" name="COMPANY_NAME" value="${e.company_name}"><br>
	部署名<input type="text" name="DEPARTMENT_NAME" value="${e.department_name}"><br>
	氏名<input type="text" name="FULL_NAME" value="${e.full_name}"><br>
	郵便番号<input type="text" name="ZIPCODE" value="${e.zipcode}"><br>
	住所<input type="text" name="ADDRESS" value="${e.address}"><br>
	電話番号<input type="text" name="TEL" value="${e.tel}"><br>
	FAX番号<input type="text" name="FAX" value="${e.fax}"><br>
	Email<input type="text" name="EMAIL" value="${e.email}"><br>
	備考<input type="text" name="REMARKS" value="${e.remarks}"><br>
	<input type="submit"  style="margin: 6px;float: left;"name="SUBMIT" value="更新">
	<input type="submit"  style="margin: 6px;float: left;"name="SUBMIT" value="削除"><br>
	</form>
	<hr>
</c:forEach>
<a href="/simpleBC/MenuServlet" class ="btn-square">トップページに戻る</a>

</div>
</body>
</html>
