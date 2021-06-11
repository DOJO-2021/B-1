<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>自己紹介|トップ画面</title>
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
  <h2>検索（入力した項目を含む名刺を検索します）</h2>
<form method="POST" action="/simpleBC/SearchServlet">
    <table>
      <tr>
        <td>
          <label>氏名<br>
          <input type="text" name="USER＿NAME">
          </label>
        </td>
        <td>
          <label>会社名<br>
          <input type="text" name="USER_COMPANY">
          </label>
        </td>
        <td>
      </tr>
      <tr>
        <td>
          <label>出身<br>
          <input type="text" name="USER_PREFECTURE">
          </label>
        </td>
        <td>
          <label>趣味<br>
          <input type="text" name="USER_HOBBY">
          </label>
        </td>
       </tr>
       <tr>
        <td>
          <label>特技<br>
          <input type="text" name="user_skill">
          </label>
        </td>
        <td>
          <label>誕生日<br>
          <input type="text" name="user_birth">
          </label>
        </td>
      </tr>
      <tr>
        <td>
          <label>備考<br>
          <input type="text" name="user_remarks">
          </label>
        </td>
        <td>
      </tr>
      <tr>
        <td colspan="2">
          <input type="submit" style="margin: 6px;float: left;"id="search" name="submit" value="検索">

        </td>
      </tr>
   </table>
</form>
<a href="/simpleBC/MenuServlet" class ="btn-square">トップページに戻る</a>
  <!-- メイン（ここまで） -->
  <!-- フッター（ここから） -->
  <div id="footer">
    <p>Copyright&copy;2021 reina murakami</p>
  </div>
  <!-- フッター（ここまで） -->
</div>
</body>
</html>