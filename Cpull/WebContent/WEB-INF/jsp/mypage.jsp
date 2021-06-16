<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マイページ</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/mypage.css">
</head>
<body>
  <header>
    <jsp:include page = "/WEB-INF/jsp/header.jsp"/>
  </header>
  <main>
    <h1>マイページ</h1>
    <form method="POST" action="/Cpull/MypageServlet">
      <table>
        <tr>
          <td>ID</td>
          <td><input type="text" name="USER_ID" value="${card.user_id}" readonly></td>
        </tr>
        <tr>
          <td>PW</td>
          <td><input type="password" name="USER_PW" value="${card.user_pw}" readonly></td> <!-- パスワード非表示/パスワード変更可？ -->
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
          <td><input type="text" name="USER_SKILL"></td>
        </tr>
        <tr>
          <td>誕生日</td>
          <td><input type="text" name="USER_BIRTH"></td>
        </tr>
        <tr>
          <td>備考</td>
          <td><input type="text" name="USER_REMARKS"></td>
        </tr>
        <tr>
          <td>クラス</td>
          <td><input type="radio" name="USER_CLASS" value="${card.user_class}" readonly><!-- ※受講者/運営表示させる --></td>
        </tr>
        <tr>
          <td>公開範囲</td>
          <td><input type="text" name="USER_RANGE"></td><!-- 公開範囲 -->
        </tr>
      </table>
      <input type="submit" name="SUBMIT" value="更新">
    </form>
  </main>
</body>
</html>