<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マイページ</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/mypage.css">
</head>
<body>
  <div class="wrapper">
    <header>
      <jsp:include page = "/WEB-INF/jsp/header.jsp"/>
    </header>
    <main>
      <h1>マイページ</h1>
      <form method="POST" action="/Cpull/MypageServlet">
        <table>
          <tr>
            <td>ID</td>
            <td><input type="text" name="id" readonly></td>
          </tr>
          <tr>
            <td>PW</td>
            <td><input type="password" name="USER_PW" readonly></td> <!-- パスワード非表示/パスワード変更可？ -->
          </tr>
          <tr>
            <td>画像</td>
            <td><input type="text" name="USER_IMAGE"></td>
          </tr>
          <tr>
            <td>※氏名</td>
            <td><input type="text" name="USER_NAME"></td> <!-- どうやって名前取り出す？ -->
          </tr>
          <tr>
            <td>※よみかた</td>
            <td><input type="text" name="USER_K_NAME"></td>
          </tr>
          <tr>
            <td>※会社名</td>
            <td><input type="text" name="USER_COMPANY"></td>
          </tr>
          <tr>
            <td>出身</td>
            <td><input type="text" name="USER_PREFECTURE"></td>
          </tr>
          <tr>
            <td>趣味</td>
            <td><input type="text" name="USER_HOBBY"></td>
          </tr>
          <tr>
            <td>特技</td>
            <td><input type="text" name="USER_SKILL" value="${e.user_skill}"></td>
          </tr>
          <tr>
            <td>誕生日</td>
            <td><input type="date" name="USER_BIRTH" min="1900-01-01" max="2021-12-31" value="${e.user_birth}"></td>
          </tr>
          <tr>
            <td>備考</td>
            <td><input type="text" name="USER_REMARKS" value="${e.user_remarks}"></td>
          </tr>
          <tr>
            <td>クラス</td>
            <td><input type="radio" name="USER_CLASS" value="${e.user_class}" readonly><!-- ※受講者/運営表示させる --></td>
          </tr>
          <tr>
            <td>公開範囲</td>
            <td>
              <select name="USER_RANGE">
                <option value="0">公開</option>
                <option value="1">非公開</option>
              </select>
            </td>
          </tr>
        </table>
        <p>※は必須項目</p>
        <input type="submit" name="SUBMIT" value="更新">
      </form>
      </c:forEach>
    </main>
  </div>
</body>
</html>