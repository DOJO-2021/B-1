'use strict';

// 未完成ファイル ID、PW、氏名、よみがな、会社名必須入力チェック

window.alert('これはテストです！');
// 新規登録画面用JavaScriptファイル
// submitボタンが押されたら「クリックされました」というメッセージを表示
document.getElementById('form').onsubmit = function(event) {
// もしも、IDかPWが未入力なら、デフォルトの動作を行わず、「IDとPWを入力してください」と表示する
  const ID = document.getElementById('form').USER_ID.value;
  const PW = document.getElementById('form').USER_PW.value;
  const check = /^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{8,15}$/;
  if(ID === null || PW === null) {
    event.preventDefault();
    document.getElementById('output').textContent = `IDまたはPWが未入力です`;
  } else if (check.PW === false) {
    event.preventDefault();
    document.getElementById('output').textContent = `PWは8文字以上16文字未満かつアルファベットと数字をどちらも含むものでなくてはなりません。`;
  }
};