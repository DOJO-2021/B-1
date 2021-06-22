'use strict';

// 未完成ファイル ID、PW、氏名、よみがな、会社名必須入力チェック

// 新規登録画面用JavaScriptファイル
document.getElementById('form').onsubmit = function(event) {
// もしも、IDかPWが未入力なら、デフォルトの動作を行わず、「IDとPWを入力してください」と表示する
  const ID = document.getElementById('form').USER_ID.value;
  const PW = document.getElementById('form').USER_PW.value;
  const check = /^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{8,15}$/;
  // 入力値取得
  var input1 = document.getElementById('form').USER_PW.value;
  var input2 = document.getElementById('form').CONFIRM.value;
  if(ID === "" || PW === "") {
    event.preventDefault();
    document.getElementById('output').textContent = `IDまたはPWが未入力です`;
  } else if (check.PW === false) {
    event.preventDefault();
    document.getElementById('output').textContent = `PWは8文字以上16文字未満かつアルファベットと数字をどちらも含むものでなくてはなりません。`;
  } else if (input1 != input2) {
    event.setCustomValidity("入力値が一致しません。");
  }
};